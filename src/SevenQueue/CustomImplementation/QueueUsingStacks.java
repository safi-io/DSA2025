package SevenQueue.CustomImplementation;

public class QueueUsingStacks {
    int capacity;
    int currentSize;
    int[] st1;
    int st1Front;
    int[] st2;
    int st2Front;

    public QueueUsingStacks(int capacity) {
        this.st1Front = this.st2Front = -1;
        this.capacity = capacity;
        st1 = new int[capacity];
        st2 = new int[capacity];
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Already Full");
            return;
        }

        st1[++st1Front] = value;
        currentSize++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        // Move all elements from st1 to st2
        while (st1Front >= 0) {
            st2[++st2Front] = st1[st1Front--];
        }

        // Remove the front element
        int removedElement = st2[st2Front--];
        currentSize--;

        System.out.println(removedElement + " has been removed!");

        // Move elements back to st1
        while (st2Front >= 0) {
            st1[++st1Front] = st2[st2Front--];
        }


    }

    public boolean isFull() {
        return this.st1Front == capacity - 1;
    }

    public boolean isEmpty() {
        return st1Front == -1;
    }

    public static void main(String[] args) {

    }
}
