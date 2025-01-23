package TwoSeaching.Two_Binary.Questions;

public class MatrixFullSorted {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 8, 10, 11}, {91, 92, 93, 94}};
        int target = 91;

        System.out.println(fullSort(arr, target));
    }

    static boolean fullSort(int[][] arr, int target) {

        int rows = arr.length;
        int cols = arr[0].length;


        int start = 0;
        int end = (rows * cols) - 1;


        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midValue = arr[mid / cols][mid % cols];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
