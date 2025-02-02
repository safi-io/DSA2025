package FiveLL.Questions;


public class sortTLE {
    private static ListNode createList() {
        ListNode node1 = new ListNode(10);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(35);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        return node1;
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

    private static int[] convertListIntoArr(ListNode head, int length) {
        int[] toReturn = new int[length];

        ListNode temp = head;
        int arrIndex = 0;
        while (temp != null) {
            toReturn[arrIndex] = temp.val;
            arrIndex++;
            temp = temp.next;
        }

        return toReturn;
    }

    private static int lenOfList(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) { // Simplify the loop condition
                if (arr[j] > arr[j + 1]) {
                    // Swap adjacent elements if they are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                // If no swaps were made in the current pass, the array is sorted
                break;
            }
        }
    }

    public static ListNode convertArrayToLinkedList(int[] array) {
        if (array.length == 0) return null;

        ListNode head = new ListNode(array[0]);
        ListNode current = head;

        for (int i = 1; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = createList();

        int length = lenOfList(head);

        int[] unsortedArr = convertListIntoArr(head, length);

        bubbleSort(unsortedArr);
        ListNode sortedList = convertArrayToLinkedList(unsortedArr);
        displayLL(sortedList);
    }
}
