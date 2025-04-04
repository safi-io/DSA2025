package Assignments.Theory_Two;

public class Runner {
    public static void main(String[] args) {
        HospitalManagementSystem hms1 = new HospitalManagementSystem(10);

        hms1.enqueue("SAFI", 10);
        hms1.enqueue("ASAD", 2);
        hms1.enqueue("ALEENA", 20);
        hms1.enqueue("SAFINA", 3);


        hms1.dequeue();
        hms1.dequeue();
        hms1.dequeue();
        hms1.dequeue();
        hms1.display();
    }
}
