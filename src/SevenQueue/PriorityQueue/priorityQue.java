package SevenQueue.PriorityQueue;

class Element {
    int value;
    int priority; // Lower value means higher priority

    public Element(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}

class PriorityQueue {
    private Element[] queue;
    private int size;

    public PriorityQueue(int capacity) {
        this.queue = new Element[capacity];
        this.size = 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int value, int priority) {
        if (isFull()) {
            System.out.println("Queue is full, cannot add element " + value);
            return;
        }
        Element newElement = new Element(value, priority);
        int i = size - 1;
        while (i >= 0 && queue[i].priority > priority) {
            queue[i + 1] = queue[i];
            i--;
        }
        queue[i + 1] = newElement;
        size++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Dequeued Element: " + queue[0].value + " (Priority: " + queue[0].priority + ")");
        for (int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }
        size--;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Front Element: " + queue[0].value + " (Priority: " + queue[0].priority + ")");
    }
}

public class priorityQue {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(5);

        pq.enqueue(10, 2);
        pq.enqueue(20, 1);
        pq.enqueue(30, 3);

        // Normal FIFO: 10,20,30
        // Priority Queue: 20,10,30

        pq.peek();
        pq.dequeue();
        pq.dequeue();
        pq.dequeue();
    }
}
