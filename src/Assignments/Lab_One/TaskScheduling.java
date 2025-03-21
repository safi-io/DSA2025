package Assignments.Lab_One;

import java.time.LocalDate;
import java.util.Locale;

public class TaskScheduling {
    private Task head, tail;
    private int numberOfTasks;

    public void addTask(String description, LocalDate deadline, String priority, String teamMember, String status) {

        int id = (tail == null) ? 1 : tail.id + 1;

        // New Task
        Task taskToAdd = new Task(id, description, deadline, priority, teamMember, status);

        if (head == null) {
            head = tail = taskToAdd;
        } else {
            tail.next = taskToAdd;
            tail = taskToAdd;
        }
        numberOfTasks++;
    }

    public void removeTask(int id) {
        if (head == null) {
            System.out.println("There are currently no tasks in system!");
            return;
        }

        if (id == head.id) {
            if (numberOfTasks == 1) {
                head = tail = null;
            } else {
                head = head.next;
            }
            System.out.println("Task Deleted with ID:" + id);
            numberOfTasks--;
            return;
        }

        if (id == tail.id) {
            Task temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }

            temp.next = null;
            tail = temp;
            System.out.println("Task Deleted with ID:" + id);
            numberOfTasks--;
            return;
        }

        // Handling the removal of in-between tasks
        Task temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Task Deleted with ID:" + id);
            numberOfTasks--;
        } else {
            System.out.println("No Task Found against the ID:" + id);
        }

    }

    public void updateTask(int id, String description, String priority, String status) {
        // Logic is if desc, priority. status is empty, just don't update it, otherwise update it.

        // Validations
        if (id <= 0) {
            System.out.println("Invalid ID");
            return;
        }
        // First Search using ID
        Task temp = head;
        while (temp != null && temp.id != id) {
            temp = temp.next;
        }
        if (temp != null) {
            // Found id
            if (description != null && !(description.trim().isEmpty())) {
                temp.description = description;
            }

            if (priority != null && !(priority.trim().isEmpty())) {
                if (!priority.equalsIgnoreCase("low") && !priority.equalsIgnoreCase("medium") && !priority.equalsIgnoreCase("high")) {
                    System.out.println("invalid priority, so setting it to MEDIUM");
                    priority = "medium";
                }
                temp.priority = priority;
            }

            if (status != null && !(status.trim().isEmpty())) {
                if (!status.equalsIgnoreCase("pending") && !status.equalsIgnoreCase("in progress") && !status.equalsIgnoreCase("completed")) {
                    System.out.println("invalid status, so setting it to IN PROGRESS");
                    status = "in progress";
                }
                temp.status = status;
            }

            System.out.println("Task with ID " + id + " has been updated.");
        } else {
            // Unable to Find id
            System.out.println("No Task Found against the ID:" + id);
        }
    }

    public void searchTask(int id) {
        // Validations
        if (id <= 0) {
            System.out.println("Invalid ID");
            return;
        }
        if (head == null) {
            System.out.println("Currently, There are no tasks in System");
            return;
        }
        Task temp = head;
        while (temp != null && temp.id != id) {
            temp = temp.next;
        }
        if (temp != null) {
            // ID Found
            System.out.println(
                    "ID: " + id + "\n" +
                            "Description: " + temp.description + "\n" +
                            "Deadline: " + temp.deadline + "\n" +
                            "Priority: " + temp.priority + "\n" +
                            "Assigned To: " + temp.teamMember + "\n" +
                            "Status: " + temp.status + "\n" +
                            "Next Task ID: " + (temp.next != null ? temp.next.id : "null")
            );

        } else {
            // Unable to Find id
            System.out.println("No Task Found against the ID:" + id);
        }
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("There are currently no tasks in system!");
            return;
        }

        // Count
        int low = 0;
        int medium = 0;
        int high = 0;

        // Getting Count of Each
        Task temp = head;
        while (temp != null) {
            if (temp.priority.equalsIgnoreCase("low")) {
                low++;
            } else if (temp.priority.equalsIgnoreCase("medium")) {
                medium++;
            } else {
                high++;
            }
            temp = temp.next;
        }

        Task[] highPriority = new Task[high];
        Task[] mediumPriority = new Task[medium];
        Task[] lowPriority = new Task[low];

        int lowIndex = 0;
        int mediumIndex = 0;
        int highIndex = 0;

        // populate
        temp = head;
        while (temp != null) {
            if (temp.priority.equalsIgnoreCase("low")) {
                lowPriority[lowIndex] = temp;
                lowIndex++;
            } else if (temp.priority.equalsIgnoreCase("medium")) {
                mediumPriority[mediumIndex] = temp;
                mediumIndex++;
            } else {
                highPriority[highIndex] = temp;
                highIndex++;
            }
            temp = temp.next;
        }

        for (int i = 0; i < highIndex; i++) {
            Task toView = highPriority[i];
            System.out.println(
                    "ID: " + toView.id + "\n" +
                            "Description: " + toView.description + "\n" +
                            "Deadline: " + toView.deadline + "\n" +
                            "Priority: " + toView.priority + "\n" +
                            "Assigned To: " + toView.teamMember + "\n" +
                            "Status: " + toView.status + "\n" +
                            "Next Task ID: " + (toView.next != null ? toView.next.id : "null")
            );
            System.out.println();
        }

        for (int i = 0; i < mediumIndex; i++) {
            Task toView = mediumPriority[i];
            System.out.println(
                    "ID: " + toView.id + "\n" +
                            "Description: " + toView.description + "\n" +
                            "Deadline: " + toView.deadline + "\n" +
                            "Priority: " + toView.priority + "\n" +
                            "Assigned To: " + toView.teamMember + "\n" +
                            "Status: " + toView.status + "\n" +
                            "Next Task ID: " + (toView.next != null ? toView.next.id : "null")
            );
            System.out.println();
        }

        for (int i = 0; i < lowIndex; i++) {
            Task toView = lowPriority[i];
            System.out.println(
                    "ID: " + toView.id + "\n" +
                            "Description: " + toView.description + "\n" +
                            "Deadline: " + toView.deadline + "\n" +
                            "Priority: " + toView.priority + "\n" +
                            "Assigned To: " + toView.teamMember + "\n" +
                            "Status: " + toView.status + "\n" +
                            "Next Task ID: " + (toView.next != null ? toView.next.id : "null")
            );
            System.out.println();
        }

        System.out.println("end");
    }

    public void overdueTasks() {
        if (head == null) {
            System.out.println("Currently, There are no tasks in System");
            return;
        }
        LocalDate currentDate = LocalDate.now();
        Task temp = head;
        while (temp != null) {
            LocalDate deadlineDate = temp.deadline;
            if (temp.status.equalsIgnoreCase("in progress")) {
                if (deadlineDate.isBefore(currentDate)) {
                    System.out.println(
                            "ID: " + temp.id + "\n" +
                                    "Description: " + temp.description + "\n" +
                                    "Deadline: " + temp.deadline + "\n" +
                                    "Priority: " + temp.priority + "\n" +
                                    "Assigned To: " + temp.teamMember + "\n" +
                                    "Status: " + temp.status + "\n" +
                                    "Next Task ID: " + (temp.next != null ? temp.next.id : "null")
                    );
                    System.out.println();
                }
            }
            temp = temp.next;
        }
    }

    public void markComplete(int id) {
        // Validations
        if (id <= 0) {
            System.out.println("Invalid ID");
            return;
        }
        Task temp = head;
        while (temp != null && temp.id != id) {
            temp = temp.next;
        }
        if (temp != null) {
            // ID Found
            String status = temp.status;
            if (!status.equalsIgnoreCase("completed")) {
                temp.status = "completed";
                System.out.println("Task with ID " + id + " has been marked completed.");
            } else {
                System.out.println("Already Completed");
            }

        } else {
            // Unable to Find id
            System.out.println("No Task Found against the ID:" + id);
        }
    }

    static class Task {
        int id;
        String description;
        LocalDate deadline;
        String priority;
        String teamMember;
        String status;
        Task next;

        public Task(int id, String description, LocalDate deadline, String priority, String teamMember, String status) {
            this.id = id;
            this.description = description;
            this.deadline = deadline;
            this.teamMember = teamMember;

            this.priority = priority.toLowerCase();
            if (!this.priority.equals("low") && !this.priority.equals("medium") && !this.priority.equals("high")) {
                System.out.println("invalid priority, so setting it to MEDIUM");
                this.priority = "medium";
            }

            this.status = status.toLowerCase();
            if (!this.status.equals("pending") && !this.status.equals("in progress") && !this.status.equals("completed")) {
                System.out.println("invalid status, so setting it to IN PROGRESS");
                this.status = "in progress";
            }

        }
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }

}
