package TwoSeaching.Two_Binary;

public class One_Code {
    public static void main(String[] args) {
        int[] array = {10,20,30,55,65,86};
        int target = 65;
        int result = binarySearch(array, target);

        if (result == -1) {
            System.out.println("Element not Found.");
        } else {
            System.out.println("Element Found at Index: " + (result));
        }
    }

    static int binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
