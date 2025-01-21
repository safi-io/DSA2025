package TwoSeaching.Two_Binary.Questions;

public class findElementInfiniteArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 213, 43, 312, 312, 31234, 311, 23, 123, 13, 12, 3123, 12, 3, 231, 31, 123, 123, 12, 3};

        int target = 3;

        System.out.println(findRange(arr, target));
    }

    static int findRange(int[] arr, int target) {
        int start = 0;
        int end = 1;
        while (arr[end] < target) {
            int temp = end + 1;
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return search(arr, target, start, end);
    }

    static int search(int[] arr, int target, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
