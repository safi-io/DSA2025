package FiveLL.One_Single;

public class One_CustomLL {

    public Node head;
    public Node tail;
    static int size;

    public One_CustomLL() {
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head; // Next time, when the tail is not null, then tail will stay at previous head, which means move further
        }

        size += 1;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        if (tail == null) {
            insertFirst(value);
            return;
        }
        tail.next = node;
        tail = node;
        size += 1;
    }

    public void insert(int value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size) {
            insertLast(value);
            return;
        }

        Node temp = head;


        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(value, temp.next);
        temp.next = node;
        size += 1;
    }

    public void deleteFirst() {
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size -= 1;

    }

    public void deleteLast() {
        if (size <= 1) {
            deleteFirst();
            return;
        }
        Node temp = head;
        for (int i = 1; i < size - 2; i++) {
            temp = temp.next;
        }
        tail = temp.next;
        tail.next = null;
        size -= 1;
    }

    public void delete(int index) {
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size - 1) {
            deleteLast();
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        // the next node have to be deleted
        temp.next = temp.next.next;
        size -= 1;
    }

    public void removeDuplicate() {
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.value == temp.next.value) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
    }

    public void displayLL() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println();
    }

    public void displayTH() {
        System.out.println(head.value);
        System.out.println(tail.value);
    }

    public class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
