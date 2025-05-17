package Assignments.Theory_Three;

public class Runner {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("---Inserting Drivers---");
        System.out.println();

        Driver d4 = new Driver(104, "Nadeem", 16);
        Driver d6 = new Driver(106, "Sadia", 11);
        Driver d1 = new Driver(101, "Ali", 20);
        Driver d3 = new Driver(103, "Sara", 30);
        Driver d2 = new Driver(102, "Ahmad", 24);
        Driver d5 = new Driver(105, "Iqbal", 6);

        minHeap heap = new minHeap();

        // Add drivers to the heap
        heap.addDriver(d3);
        heap.addDriver(d5);
        heap.addDriver(d2);
        heap.addDriver(d6);
        heap.addDriver(d1);
        heap.addDriver(d4);

        System.out.println();
        System.out.println("---Assigning Drivers---");
        System.out.println();

        System.out.println(heap.removeDriverShortestDistance() + " is assigned because of the shortest distance");
        System.out.println(heap.removeDriverShortestDistance() + " is assigned because of the shortest distance");

        System.out.println();
        System.out.println("---Peeking Drivers---");
        System.out.println();

        // Peek at the driver currently at shortest distance without removing
        System.out.println(heap.getDriverShortestDistance() + " is at the shortest distance");

    }
}
