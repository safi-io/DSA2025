package TwoSeaching.Two_Binary.Questions;

public class mountainArray {
    public static void main(String[] args) {
        int[] arr = {3,5,3,2,0};
        System.out.println(peakElement(arr));
    }

    static int peakElement(int[] arr) {
        int start = 1;
        int end = arr.length - 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
