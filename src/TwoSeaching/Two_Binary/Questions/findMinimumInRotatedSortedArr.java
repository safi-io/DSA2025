package TwoSeaching.Two_Binary.Questions;

public class findMinimumInRotatedSortedArr {
    public static void main(String[] args) {
        int[] arr = {9,10,11,12,4,5};

        System.out.println("Minimum Element is: " + findMinRot(arr)  );
    }

    static int findMinRot(int[] arr) {
        int minimumValue = Integer.MAX_VALUE;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // Left Part is Sorted
            if (arr[start] <= arr[mid]) {
                minimumValue = Math.min(minimumValue, arr[start]);
                start = mid + 1;

            }
            // Checking if right part is sorted
            else{
                end = mid - 1;
                minimumValue = Math.min(minimumValue, arr[mid]);
            }
        }
        return minimumValue;
    }
}
