package FiveLL.Questions;

import FiveLL.One_Single.One_CustomLL;
import org.w3c.dom.NodeList;

import java.util.List;

public class reOrder {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;

        displayLL(n1);
        ListNode rev = revLL(n1, findMiddle(n1), listLength(n1));
        displayLL(rev);

        // First Head (n1)
        // Second Head
        ListNode secondHead = n1;
        for (int i = 1; i < findMiddle(n1); i++) {
            secondHead = secondHead.next;
        }

        secondHead.next = null;

        reOrderList(n1, secondHead);
        displayLL(n1);

    }

    private static void displayLL(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println();
    }

    private static ListNode revLL(ListNode head, int start, int end) {
        if (start == end || head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 1, 2, 3, 4, 5
        // 1, 4,3,2,  5

        ListNode prevStart = dummy;
        for (int i = 1; i < start; i++) {
            prevStart = prevStart.next; //1
        }

        ListNode startRevIndex = prevStart.next; // 2

        ListNode currIndex = startRevIndex;
        ListNode prev = null;

        for (int i = start; i <= end; i++) {
            ListNode next = currIndex.next;
            currIndex.next = prev;
            prev = currIndex;
            currIndex = next;
        }

        prevStart.next = prev;
        startRevIndex.next = currIndex;

        return dummy.next;

    }

    private static int listLength(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

    private static int findMiddle(ListNode head) {
        ListNode fast = head;

        int count = 0;

        while (fast != null && fast.next != null) {
            count++;
            fast = fast.next.next;
        }

        return count + 1;
    }

    private static void reOrderList(ListNode hf, ListNode hs) {
        while (hf != null && hs != null){
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;
            temp =hs.next;
            hs.next = hf;
            hs =temp;
        }
    }
}
