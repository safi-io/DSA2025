package Assignments.Lab_Three.Airport;

public class Runner {
    public static void main(String[] args) {
        minHeapAirport runway = new minHeapAirport();

        // Add planes
        runway.addPlane(new Plane("A101", 3));
        runway.addPlane(new Plane("B205", 1));
        runway.addPlane(new Plane("C309", 2));
        runway.addPlane(new Plane("D412", 3));
        runway.addPlane(new Plane("E510", 2));
        runway.addPlane(new Plane("F618", 3));
        runway.addPlane(new Plane("G720", 1));

        System.out.println("\n--- Landing Sequence ---");
        while (!runway.isEmpty()) {
            Plane landing = runway.removeHighestPriorityPlane();
            System.out.println("Plane " + landing.getPlaneId() + " is landing (Priority: " + landing.getPriority() + ")");
        }
    }
}
