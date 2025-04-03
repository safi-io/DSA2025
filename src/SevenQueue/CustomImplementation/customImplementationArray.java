package SevenQueue.CustomImplementation;

class customQueue {

    // Implementing using Arrays.

    // Withdraw is wastage of memory, can be resolved using circular queue
    private int[] queue;
    private int front;
    private int rear;
    private int currSize;
    private int maxSize;

    public customQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        front = -1;
        rear = -1;
        currSize = 0;
    }

    public void enqueue(int value) {
        if (currSize == maxSize) {
            System.out.println("Queue is Full.");
            return;
        } else if (front == -1 && rear == -1) {
            front = rear = 0;
            queue[rear] = value;
        } else {
            queue[++rear] = value;
        }
        currSize++;
    }

    public int dequeue() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is Already Empty!");
            System.exit(1);
        }
        int popped = queue[front++];

        if (currSize == 1) {
            front = rear = -1;
        }

        currSize--;
        return popped;
    }

    public int peek() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is Empty.");
            System.exit(1);
        }
        return queue[front];
    }

    public int getSize() {
        return currSize;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class customImplementationArray {
    public static void main(String[] args) {
        customQueue q1 = new customQueue(2);

        q1.enqueue(20);
        q1.enqueue(60);
        q1.enqueue(70);

        q1.display();
    }
}
