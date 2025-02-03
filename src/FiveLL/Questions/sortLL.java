package FiveLL.Questions;


public class sortLL {
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

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);  // Left Portion of Array
            mergeSort(arr, mid + 1, right); // Right Portion of Array

            // Merge Sorted Halves
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary Arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);

        int i = 0;
        int j = 0;
        int index = left;

        while (i < n1 && j < n2) {

            if (leftArray[i] <= rightArray[j]) {
                arr[index] = leftArray[i];
                i++;
            } else {
                arr[index] = rightArray[j];
                j++;
            }
            index++;
        }

        while (i < n1) {
            arr[index] = leftArray[i];
            i++;
            index++;
        }

        while (j < n2) {
            arr[index] = rightArray[j];
            j++;
            index++;
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

        mergeSort(unsortedArr, 0, length - 1);
        ListNode sortedList = convertArrayToLinkedList(unsortedArr);
        displayLL(sortedList);
    }
}
