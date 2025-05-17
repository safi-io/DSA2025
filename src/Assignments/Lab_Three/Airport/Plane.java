package Assignments.Lab_Three.Airport;

public class Plane {
    String id;
    int priority; // 1 = Emergency, 2 = Low Fuel, 3 = Normal

    Plane(String id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    public String getPlaneId() {
        return this.id;
    }

    public int getPriority() {
        return this.priority;
    }
}