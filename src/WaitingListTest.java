import org.junit.Test;       // JUnit annotation for test methods
import static org.junit.Assert.*; // Assertion methods

// test class to validate functionalities
public class WaitingListTest {
    // ======================
    // Normal Test Cases
    // ======================

    // # 1: adds person & verifies count increase to 1. then count comes down to 0 when the person is served
    @Test
    public void testBasicAddAndServe() {
        WaitingListManager manager = new WaitingListManager();

        // Add person
        manager.addPerson("Bona");
        assertEquals("Queue size should be 1 after add", 1, manager.getWaitingCount());

        // Serve person
        assertEquals("Should serve Bona", "[SERVED] Bona", manager.servePerson());
        assertEquals("Queue should be empty after serving", 0, manager.getWaitingCount());
    }

    // # 2: FIFO order
    @Test
    public void testServiceOrder() {
        WaitingListManager manager = new WaitingListManager();

        manager.addPerson("Mary");
        manager.addPerson("Jack");

        assertEquals("First added should be first served", "[SERVED] Mary", manager.servePerson());
        assertEquals("Second added should be second served", "[SERVED] Jack", manager.servePerson());
    }

    // # 3: check for duplicate
    @Test
    public void testDuplicateHandling() {
        WaitingListManager manager = new WaitingListManager();

        manager.addPerson("Jerry");
        manager.addPerson("Jerry");

        assertEquals("Duplicate should be ignored", 1, manager.getWaitingCount());
    }

    // ======================
    // Edge Test Cases
    // ======================

    // # 1: Empty queue
    @Test
    public void testEmptyList() {
        WaitingListManager manager = new WaitingListManager();
        assertEquals("Should handle empty queue", "[EMPTY] No one is waiting.", manager.servePerson());
    }

    // # 2: Case sensitivity test
    @Test
    public void testCaseSensitivity() {
        WaitingListManager manager = new WaitingListManager();
        manager.addPerson("rob");
        assertTrue("Should be case-sensitive", manager.isPersonInList("rob"));
    }

    // # 3: Empty string test
    @Test
    public void testEmptyString() {
        WaitingListManager manager = new WaitingListManager();

        manager.addPerson(""); // Empty string
        assertTrue("Empty string should be allowed", manager.isPersonInList(""));

        assertEquals("Should serve empty string", "[SERVED] ", manager.servePerson());
    }
}