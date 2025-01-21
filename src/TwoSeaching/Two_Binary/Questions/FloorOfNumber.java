package TwoSeaching.Two_Binary.Questions;

public class FloorOfNumber {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 1;
        int result = floor(arr, target);

        if (result == -1) {
            System.out.println("THERE IS NO SUCH NUMBER.");
        } else {
            System.out.println("Floor of " + target + " is: " + result);
        }
    }

    private static int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // If the smallest number in the array is greater than the target, no floor exists
        if (arr[0] > target) {
            return -1;
        }

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == target) {
                return arr[mid]; // Return the target itself if it matches
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // `end` will point to the greatest number smaller than the target
        return arr[end];
    }
}
