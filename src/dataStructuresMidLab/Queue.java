package dataStructuresMidLab;

public class Queue {
    private Node head;
    private Node tail;
    private int currentSize;

    public void enqueue(int passengerID, String passengerName) {
        Node new_node = new Node(passengerID, passengerName);

        if (head == null) {
            head = tail = new_node;
        } else {
            tail.next = new_node;
            tail = new_node;
        }
        currentSize++;
    }

    public Node dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("No Passengers Found in Queue.");
        }
        Node frontMostElement = head;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        currentSize--;
        return frontMostElement;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("No Passengers.");
        }

        return head.passengerID;
    }

    public void display() {
        if (isEmpty()) {
            throw new RuntimeException("No Passengers Found in Queue.");
        }

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.passengerID + " " + temp.passengerName + " ");
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
        int passengerID;
        String passengerName;
        Node next;

        public Node(int passengerID, String passengerName) {
            this.passengerID = passengerID;
            this.passengerName = passengerName;
        }
    }
}
