package dataStructuresMidLab;

public class StackDriver {
    private Node top;
    private int size;

    public StackDriver() {
        top = null;
        size = 0;
    }

    public void push(int driverID, String driverName) {
        Node temp = new Node(driverID, driverName);
        if (temp == null) {
            System.out.println("Stack Overflow");
            return;
        }
        temp.next = top;
        top = temp;
        size += 1;
    }

    public Node pop() {
        if (size <= 0) {
            System.out.println("Driver-Stack Underflow");
            return null;
        }
        Node toReturn = top;
        top = top.next;
        size -= 1;
        return toReturn;
    }

    public int peek() {
        if (top == null) {
            System.out.println("Driver-Stack is Empty");
            return -1;
        }

        return top.driverID;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int isSize() {
        return size;
    }

    public void display() {
        System.out.println("SHOWING HISTORY");
        displayRecursive(top);
        System.out.println("HISTORY END");
    }

    private void displayRecursive(Node node) {
        if (node == null) return;

        System.out.println(node.driverID + " " + node.driverName);
        displayRecursive(node.next);
    }


    static class Node {
        public int driverID;
        public String driverName;
        public Node next;

        public Node(int driverID, String driverName) {
            this.driverID = driverID;
            this.driverName = driverName;
        }
    }
}
