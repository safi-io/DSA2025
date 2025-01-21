package TwoSeaching.Two_Binary.Questions;

public class CeilingOfNumber {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 19;

        int result = ceiling(arr, target);

        if (result == 1) {
            System.out.println("TARGET ALREADY PRESENT IN ARRAY.");
        } else if (result == -1) {
            System.out.println("THERE IS NO SUCH NUMBER.");
        } else {
            System.out.println(result);
        }
    }

    /**
     * This method finds the ceiling of the target in the given sorted array.
     * The ceiling is the smallest number in the array that is greater than or equal to the target.
     *
     * @param arr    The input sorted array
     * @param target The target number
     * @return The ceiling value, or -1 if no ceiling exists
     */

    private static int ceiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // If the largest number in the array is smaller than the target, no ceiling exists
        if (arr[arr.length - 1] < target) {
            return -1;
        }

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (arr[mid] == target) {
                return 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return arr[start];
    }
}
