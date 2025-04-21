package dataStructuresMidLab;

public class SmartRideManagementSystem {
    public static void main(String[] args) {
        Queue passengers = new Queue();
        LinkedList rides = new LinkedList();
        StackDriver drivers = new StackDriver();
        StackHistory history = new StackHistory();

        passengers.enqueue(101, "Ali");
        passengers.enqueue(102, "Ahmad");
        passengers.enqueue(103, "Alem");

        rides.insertLast(201, "Faisalabad", "Lahore", 200);
        rides.insertLast(202, "Faisalabad", "Karachi", 800);
        rides.insertLast(203, "Multan", "Islamabad", 1200);

        drivers.push(301, "John");
        drivers.push(302, "Doe");
        drivers.push(303, "William");

        assignRide(passengers, rides, drivers, history);

        // Show History Only
        history.display();
    }

    private static void assignRide(Queue passengers, LinkedList rides, StackDriver drivers, StackHistory history) {

        Queue.Node passenger = passengers.dequeue();
        StackDriver.Node driver = drivers.pop();
        LinkedList.Ride ride = rides.deleteJob(rides.removeFirst().rideID);

        history.push(ride.rideID, passenger.passengerID, passenger.passengerName, driver.driverID, driver.driverName);

    }
}
