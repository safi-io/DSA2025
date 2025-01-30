package FiveLL.Doubly;

public class One_DoublyLL {

    private int size;
    private Node head;

    public void insertFirst(int value) {
        Node node = new Node(value);

        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }

        head = node;
        size += 1;
    }

    public void insertLast(int value) {
        if (size < 1) {
            insertFirst(value);
            return;
        }

        Node node = new Node(value);
        node.next = null;

        // need last index
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // i have the last node in temp
        temp.next = node;
        node.prev = temp;

        size += 1;
    }

    public void insert(int value, int index) {
        Node node = new Node(value);

        // Approaching index
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Index out of range");
            return;
        }
        // Got the index
        node.next = temp.next;
        temp.next = node;
        node.prev = temp;
        temp.next.prev = node;

    }

    public void displayLL() {
        Node temp = head;
        Node rev = null;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            rev = temp;
            temp = temp.next;
        }

        System.out.print("End");
        System.out.println();

//        while (rev != null) {
//            System.out.print(rev.value + " -> ");
//            rev = rev.prev;
//        }
//        System.out.print("Start");
//        System.out.println();
    }

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
