# Waiting List Manager

## Overview
This project simulates a restaurant waiting list that ensures no duplicate entries. It uses a **Queue** to maintain **FIFO** (First-In-First-Out) order and a **Set** to enforce uniqueness. The system allows users to add, serve, check, and display guests on the waiting list.

## Features
- **Add Guest**: Adds a person to the waiting list while preventing duplicates.
- **Serve Guest**: Removes and returns the first person in the waiting list.
- **Check Guest**: Checks if a person is currently on the waiting list.
- **Show Count**: Displays the number of people waiting.
- **JUnit Tests**: Ensures correct functionality with normal and edge test cases.

## Technologies Used
- **Java** (Core Logic)
- **JUnit 4** (Testing Framework)

## Project Structure
WaitingListManager.java # Main logic for managing the waiting list WaitingList.java # User interaction (console-based) WaitingListTest.java # JUnit test cases

## Installation & Usage
### Prerequisites
- JDK 8+ installed
- JUnit 4 (for testing)

### Running the Application
Compile and run the `WaitingList.java` file:

javac WaitingList.java
java WaitingList

### Running the Tests
Clone the program and run the WaitingListTest.java

### Test Cases

The JUnit test suite (WaitingListTest.java) validates core functionalities:
## Normal Cases

    Basic Add & Serve: Ensures correct queue operation.
    FIFO Order: Validates first-come, first-served logic.
    Duplicate Prevention: Ensures no duplicate entries.

## Edge Cases

    Empty Queue: Checks behavior when trying to serve from an empty list.
    Case Sensitivity: Ensures names are case-sensitive.
    Empty String Handling: Checks if empty names are managed correctly.