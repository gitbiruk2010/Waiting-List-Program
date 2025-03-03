import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// main class
class WaitingListManager {
    // Queue to maintain order of arrival (First-In-First-Out)
    private final Queue<String> waitingQueue = new LinkedList<>();
    // Set to track unique names and prevent duplicates
    private final Set<String> uniqueNames = new HashSet<>();

    //method do add person
    public void addPerson(String name) {
        // Check for duplicates using the Set
        if (uniqueNames.contains(name)) {
            System.out.println("[DUPLICATE] " + name + " is already in the list.");
            return;
        }

        // Add to both Queue and Set
        waitingQueue.add(name);
        uniqueNames.add(name);
        System.out.println("[ADDED] " + name);
    }

    // method to serve the person in line
    public String servePerson() {
        if (waitingQueue.isEmpty()) {
            return "[EMPTY] No one is waiting.";
        }

        // Remove from both Queue and Set
        String servedPerson = waitingQueue.poll();
        uniqueNames.remove(servedPerson);
        return "[SERVED] " + servedPerson;
    }

    //method to check if person is in the waiting list
    public boolean isPersonInList(String name) {
        // Use Set for O(1) lookup time
        return uniqueNames.contains(name);
    }

    //method to get count of the waiting list
    public int getWaitingCount() {
        // Queue size reflects actual waiting count
        return waitingQueue.size();
    }

}