package SevenQueue.CircularQueue;

public class customCircularQueue {

    int count;
    int capacity;
    int front;
    int rear;
    int[] arr;

    public customCircularQueue(int capacity) {
        count = 0;
        front = rear = -1;
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public void enqueue(int value) {

        if ((rear + 1) % capacity == front) {
            System.out.println("Queue is Full...");
            return;
        }

        if (front == -1) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        arr[rear] = value;
        count++;
    }

    public int deque() {

        if (front == -1) {
            System.out.println("Queue is Empty...");
            return -1;
        }

        int toReturn = arr[front];

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }

        return toReturn;
    }

    public void display() {
        if (front == -1) {
            System.out.println("Queue is Empty...");
            return;
        }

        System.out.print("Queue: ");

        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");

            if (i == rear) { // Stop when we reach rear
                break;
            }

            i = (i + 1) % capacity; // Move circularly
        }

        System.out.println("end.");
    }


    public static void main(String[] args) {
        customCircularQueue queue = new customCircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();

        queue.deque();
        queue.enqueue(60);

        queue.display();

    }
}
