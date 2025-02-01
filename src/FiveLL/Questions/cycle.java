package FiveLL.Questions;

public class cycle {

    public static ListNode createCycleList() {
        // Create individual nodes
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);

// Connect the nodes to form a linked list: 1 -> 2 -> ... -> 10
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

// Create the cycle: 10 -> 1
//        node10.next = node5;


        return node1;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet, there's a cycle
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static int lengthCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet, there's a cycle
            if (slow == fast) {
                ListNode cycleLen = slow.next;
                int length = 1;
                while (cycleLen != slow) {
                    length++;
                    cycleLen = cycleLen.next;
                }
                return length;
            }
        }
        return -1;
    }

    public static ListNode startCycleVal(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
//            there's a cycle
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return new ListNode(123);
    }

    public static int lengthLL(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode head = createCycleList();
        System.out.println(lengthLL(head));

//        System.out.println("Length of Cycle is: " + lengthCycle(head));
//        System.out.println(startCycleVal(head).val);
    }
}
