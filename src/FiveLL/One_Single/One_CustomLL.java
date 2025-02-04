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

    public void insert(int val, int index) {
        if (index >= size) {
            return; // Returning because index is not valid
        }

        if (size == 0) { // It means that the Linked List is empty!
            insertFirst(val);
        }

        Node toAdd = new Node(val);
        Node temp = head;
        int count = 0;

        while (temp != null) {
            if (count == index - 1) {
                toAdd.next = temp.next;
                temp.next = toAdd;
                size += 1;
                return;

            }
            count++;
            temp = temp.next;
        }

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

    public void reverseBetween(int left, int right) {
        Node prevStartIndex = null;
        Node startIndex = null;
        Node endIndex = null;
        Node nextEndIndex = null;

        // Traversing the Linked List
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if ((left - 1) == count) {
                prevStartIndex = temp;
            } else if ((left) == count) {
                startIndex = temp;
            } else if ((right - 1) == count) {
                endIndex = temp;
            } else if (right == count) {
                nextEndIndex = temp;
                break;
            }
            temp = temp.next;
        }

        revBetween2(startIndex, prevStartIndex, endIndex, nextEndIndex);

    }

    public void revBetween2(Node startIndex, Node prevStartIndex, Node endIndex, Node nextEndIndex) {
        Node current = startIndex;
        Node prev = nextEndIndex; // Important to connect the reversed part correctly
        Node next;

        // Reverse the segment
        while (current != nextEndIndex) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Reconnect the reversed part
        if (prevStartIndex != null) {
            prevStartIndex.next = endIndex;
        } else {
            head = endIndex; // Update head if reversing from the start
        }
    }

    public void binaryToDecimal() {
        StringBuilder s = new StringBuilder();
        while (head != null) {
            s.append(head.value);
            head = head.next;
        }

        System.out.println(Integer.parseInt(s.toString(), 2));
    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        int count = 0;
        Node temp = head;
        while (temp != null) {
            if (count == index) {
                return temp.value;
            }
            count++;
            temp = temp.next;
        }
        return 0;
    }

    public static Node sumLL(One_CustomLL LL1, One_CustomLL LL2) {
        Node head1 = LL1.head;
        Node head2 = LL2.head;

        Node dummyNode = new Node(-1);
        Node current = dummyNode;
        int carry = 0;

        while (head1 != null || head2 != null) {
            int sum = 0;
            sum += carry;

            if (head1 != null) {
                sum += head1.value;
            }
            if (head2 != null) {
                sum += head2.value;
            }

            Node toAdd = new Node(sum % 10);
            carry = sum / 10;
            current.next = toAdd;
            current = current.next;


            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }

        return dummyNode.next;
    }

    public static class Node {
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
