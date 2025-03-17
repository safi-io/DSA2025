package SevenQueue;

class Queue {
    Node head;
    Node tail;
    int currentSize;

    public void enqueue(int value) {
        Node new_node = new Node(value);

        if (head == null) {
            head = tail = new_node;
        } else {
            tail.next = new_node;
            tail = new_node;
        }
        currentSize++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        int frontMostElement = head.data;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        currentSize--;
        return frontMostElement;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }

        return head.data;
    }

    public void display() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}


public class customImplementationLinkedList {
    public static void main(String[] args) {
        Queue q1 = new Queue();
        q1.enqueue(20);
        q1.enqueue(30);
        q1.enqueue(40);
        q1.display();

        q1.dequeue();
        q1.dequeue();
        q1.dequeue();

        q1.display();
    }
}
