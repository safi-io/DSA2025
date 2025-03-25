package SevenQueue.CircularQueue;

public class circularQueueLL {
    Node head, tail;
    int currentSize;


    public void enqueue(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = tail = new_node;
        } else {
            tail.next = new_node;
            tail = new_node;
        }
        currentSize++;
        tail.next = head;
    }

    public void dequeue() {
        if (head == null) {
            System.out.println("Queue is Empty");
            return;
        }
        int toRemove = 0;
        if (head == tail) {
            toRemove = head.data;
            head = tail = null;
        } else {
            toRemove = head.data;
            head = head.next;
            tail.next = head;
        }
        currentSize--;
        System.out.println(toRemove + " has been removed!");
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

    }

    public static void main(String[] args) {

    }
}
