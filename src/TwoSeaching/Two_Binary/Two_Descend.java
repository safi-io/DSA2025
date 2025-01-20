package TwoSeaching.Two_Binary;

public class Two_Descend {
    public static void main(String[] args) {
        int[] arr = {90, 80, 70, 60, 50, 40, 30, 20, 10};
        int target = 10;

        int result = descendBinary(arr, target);
        if (result == -1) {
            System.out.println("Element not Found.");
        } else {
            System.out.println("Element Found at index: " + result);
        }
    }

    static int descendBinary(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target ) {
                start = mid+1;
            }else {
                end = mid-1;
            }

        }

        return -1;
    }
}
