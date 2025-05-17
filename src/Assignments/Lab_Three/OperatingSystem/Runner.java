package Assignments.Lab_Three.OperatingSystem;

public class Runner {
    public static void main(String[] args) {
        TaskMinHeap scheduler = new TaskMinHeap();

        // Simulating task arrivals with priority and timestamp
        scheduler.enqueue(new Task("Real-Time Sensor Event", 1, System.currentTimeMillis()));
        scheduler.enqueue(new Task("User Opens App", 2, System.currentTimeMillis() + 100));
        scheduler.enqueue(new Task("System Update", 3, System.currentTimeMillis() + 200));
        scheduler.enqueue(new Task("Mouse Click Event", 1, System.currentTimeMillis() + 50));
        scheduler.enqueue(new Task("User Sends Message", 2, System.currentTimeMillis() + 150));
        scheduler.enqueue(new Task("Background Cleanup", 3, System.currentTimeMillis() + 300));
        scheduler.enqueue(new Task("Critical Interrupt", 1, System.currentTimeMillis() + 30));

        System.out.println("\n--- Executing Tasks in Priority Order ---");
        while (!scheduler.isEmpty()) {
            Task task = scheduler.dequeue();
            System.out.println("Executing: " + task.getName() +
                    " (Priority: " + task.getPriority() + ", Time: " + task.getTimestamp() + ")");
        }
    }
}
