package FiveLL.Circular;

public class One_CLL {

    private int size;
    private Node head;
    private Node tail;

    public One_CLL() {
        this.head = null;
        this.tail = null;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        }
        tail.next = node;
        node.next = head;
        tail = node;
        size += 1;

    }

//    public void delete(int value) {
//        Node temp = head;
//        if (temp == null) return;
//
//        if (temp.value == value) {
//            head = head.next;
//            tail.next = head;
//            return;
//        }
//
//        while (temp.value != value) {
//            temp = temp.next;
//        }
//        // i have the node that I have to del
//        System.out.println(temp.value);
//
//    }

    public void display() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.value + "->");
                temp = temp.next;
            } while (temp != head);
        }
        System.out.print("HEAD");
        System.out.println();
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
