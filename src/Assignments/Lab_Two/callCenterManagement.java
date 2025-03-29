package Assignments.Lab_Two;

public class callCenterManagement {
    private final Stack history;
    private final Queue calls;

    public callCenterManagement() {
        history = new Stack();
        calls = new Queue();
    }

    void addCall(int callID, String description) {
        int callAdded = calls.enqueue(callID, description);
        System.out.println("CALL ADDED: " + callAdded);
    }

    void processCall() {

        Node toRemove = calls.dequeue();
        if(toRemove == null) {
            return;
        }
        history.push(toRemove.callID, toRemove.description);
    }

    void displayCalls() {
        calls.display();
    }

    void popHistory() {
        Node popped = history.pop();
        if(popped == null) {
            System.out.println("No History for Calls.");
        }else {
            System.out.println(popped.callID + " has been popped!");
        }
    }

    void displayHistory() {
        history.display();
    }

    public Queue getCalls() {
        return calls;
    }

    public Stack getHistory() {
        return history;
    }
}

class Stack {
    Node head;

    public Stack() {
        head = null;
    }

    public int push(int callID, String description) {
        Node new_node = new Node(callID, description);

        if (head != null) {
            new_node.next = head;
        }
        head = new_node;

        return head.callID;
    }

    public Node pop() {
        if (head == null) {
            return null;
        }

        Node toReturn = head;
        head = head.next;
        return toReturn;
    }

    public void display() {

        if(head==null) {
            System.out.println("No History for Calls.");
            return;
        }

        Stack temp = new Stack();

        while (head != null) {
            Node popped = this.pop();
            System.out.println("CALL ID: " + popped.callID + ", Description: " + popped.description);
            temp.push(popped.callID, popped.description);
        }

        while (temp.head != null) {
            Node popped = temp.pop();
            this.push(popped.callID, popped.description);
        }

    }

    public Node peek() {
        return head;
    }
}

class Queue {
    Node head;
    Node tail;

    public Queue() {
        head = tail = null;
    }

    public int enqueue(int callID, String description) {
        Node new_node = new Node(callID, description);

        if (head == null) {
            head = tail = new_node;
        } else {
            tail.next = new_node;
            tail = new_node;
        }

        return new_node.callID;
    }

    public Node dequeue() {
        if (head == null) {
            System.out.println("No Calls in the Queue!");
            return null;
        }

        Node toReturn = head;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        return toReturn;
    }

    public void display() {
        if (head == null) {
            System.out.println("No Calls in the Queue!");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.println("CALL ID:" + temp.callID + ", Description:" + temp.description);
            temp = temp.next;
        }
    }

    public Node peek() {
        return head;
    }
}

class Node {
    int callID;
    String description;
    Node next;

    public Node(int callID, String description) {
        this.callID = callID;
        this.description = description;
    }

    public int getCallID() {
        return callID;
    }
}
