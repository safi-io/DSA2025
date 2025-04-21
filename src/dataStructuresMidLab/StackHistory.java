package dataStructuresMidLab;

public class StackHistory {
    Node top;
    int size;

    public StackHistory() {
        top = null;
        size = 0;
    }

    public void push(int rideID, int passengerID, String passengerName, int driverID, String driverName) {
        Node temp = new Node(rideID, passengerID, passengerName, driverID, driverName);

        if (temp == null) {
            System.out.println("History-Stack Overflow");
            return;
        }
        System.out.println(temp.driverID + " Pushed!");

        temp.next = top;
        top = temp;
        size += 1;
    }

    public void pop() {
        if (size <= 0) {
            System.out.println("History-Stack Underflow");
            return;
        }
        System.out.println(top.rideID + " Popped!");
        top = top.next;
        size -= 1;
    }

    public int peek() {
        if (top == null) {
            System.out.println("History-Stack is Empty");
            return -1;
        }

        return top.rideID;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int isSize() {
        return size;
    }

    public void display() {
        System.out.println("SHOWING HISTORY");
        displayRecursive(top);
        System.out.println("HISTORY END");
    }

    private void displayRecursive(Node node) {
        if (node == null) return;

        Node temp = top;
        top = top.next;

        displayRecursive(top);

        System.out.println("\t\tRide ID:" + temp.rideID);
        System.out.println("\t\tPassenger ID:" + temp.passengerID);
        System.out.println("\t\tPassenger Name:" + temp.passengerName);
        System.out.println("\t\tDriver ID:" + temp.driverID);
        System.out.println("\t\tDriver Name:" + temp.driverName);
        System.out.println("NEXT HISTORY");

        temp.next = top;
        top = temp;
    }

    public class Node {
        public int rideID;

        public int passengerID;
        private String passengerName;

        public int driverID;
        private String driverName;

        public Node next;

        public Node(int rideID, int passengerID, String passengerName, int driverID, String driverName) {
            this.rideID = rideID;
            this.passengerID = passengerID;
            this.passengerName = passengerName;
            this.driverID = driverID;
            this.driverName = driverName;
        }
    }
}
