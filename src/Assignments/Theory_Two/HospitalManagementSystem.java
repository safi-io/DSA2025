package Assignments.Theory_Two;

class Patient {
    String name;
    int priority;

    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
}

public class HospitalManagementSystem {
    private int front;
    private int rear;
    private final Patient[] queue;
    private final int capacity;
    private int currentSize;

    public HospitalManagementSystem(int capacity) {
        front = rear = -1;
        queue = new Patient[capacity];
        this.capacity = capacity;
        currentSize = 0;
    }

    public void enqueue(String name, int priority) {
        Patient newPatient = new Patient(name, priority);
        if (capacity == currentSize) {
            System.out.println("Queue Already Fill.");
            return;
        } else if (front == -1 && rear == -1) {
            front = rear = 0;
            queue[rear] = newPatient;
        } else {
            int i = rear;
            while (i >= front && newPatient.priority < queue[i].priority) {
                queue[i + 1] = queue[i];
                i--;
            }

            queue[i + 1] = newPatient;
            rear++;
        }
        currentSize++;
    }

    public void dequeue() {
        if(front == -1 && rear ==-1) {
            System.out.println("Queue Already Empty");
            return;
        }
        front++;
        currentSize--;
        if (front > rear) { // If the queue becomes empty after dequeue
            front = rear = -1;
        }
    }

    public void display() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty.");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.println(queue[i].name);
        }
    }



}
