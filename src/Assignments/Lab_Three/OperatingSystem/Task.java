package Assignments.Lab_Three.OperatingSystem;

public class Task {
    private String name;
    private int priority; // 1 = Real-time, 2 = User, 3 = Background
    private long timestamp; // For simulation

    public Task(String name, int priority, long timestamp) {
        this.name = name;
        this.priority = priority;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
