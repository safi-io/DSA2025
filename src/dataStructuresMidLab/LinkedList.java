package dataStructuresMidLab;

public class LinkedList {
    private Ride head;
    private Ride tail;
    static int size;

    private void insertFirst(int rideID, String rideFrom, String rideTo, float fare) {
        Ride ride = new Ride(rideID, rideFrom, rideTo, fare);
        ride.next = head;
        head = ride;

        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void insertLast(int rideID, String rideFrom, String rideTo, float fare) {
        Ride ride = new Ride(rideID, rideFrom, rideTo, fare);
        if (tail == null) {
            insertFirst(rideID, rideFrom, rideTo, fare);
            return;
        }
        tail.next = ride;
        tail = ride;
        size += 1;
    }

    public void displayRides() {
        Ride ride = this.head;
        while (ride != null) {
            System.out.print(ride.rideID + " From:" + ride.rideFrom + " To:" + ride.rideTo + " Fare:" + ride.fare + "->");
            ride = ride.next;
        }
        System.out.print("END");
        System.out.println();
    }

    public Ride deleteJob(int rideID) {
        if (head == null) {
            System.out.println("There are currently no RIDES in list!");
            return null;
        }

        // Checking tail
        if(tail.rideID == rideID) {
            Ride temp = head;

            while(temp.next!=tail) {
                temp = temp.next;
            }
            size--;
            tail = temp;
        }

        // Case 1: Delete the Head Job
        if (head.rideID == rideID) {

            // If there is only Job
            if (size == 1) {
                Ride toReturn = head;
                head = null;
                size--;
                System.out.println("Deleted ride with ID: " + rideID);
                return toReturn;
            }
            // Move head ahead
            Ride toReturn = head;
            head = head.next;
            System.out.println("Deleted ride with ID: " + rideID);
            size--;
            return toReturn;
        }

        // Case 2: Delete non-head job
        Ride temp = head;
        while (temp.next != null && temp.next.rideID != rideID) {
            temp = temp.next;
        }

        // If the below condition works, it means we traverse the whole list, still haven't found the job
        if (temp.next == null) {
            System.out.println("No RIDE FOUND");
            return null;
        }

        // Finally, remove the job
        Ride toReturn = temp.next;
        temp.next = temp.next.next;
        size--;
        System.out.println("Deleted ride with ID: " + rideID);
        return toReturn;
    }

    public Ride removeFirst() {
        if (head == null) {
            System.out.println("List is empty!");
            return null;
        }

        Ride temp = head;
        head = head.next;

        // If the list had only one element
        if (head == null) {
            tail = null;
        }

        size--;
        return temp;
    }

    public static class Ride {
        int rideID;
        private String rideFrom;
        private String rideTo;
        private float fare;
        private Ride next;

        public Ride(int rideID, String rideFrom, String rideTo, float fare) {
            this.rideID = rideID;
            this.rideFrom = rideFrom;
            this.rideTo = rideTo;
            this.fare = fare;
        }
    }
}
