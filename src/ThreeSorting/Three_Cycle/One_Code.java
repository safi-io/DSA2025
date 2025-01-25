package ThreeSorting.Three_Cycle;

import java.util.Arrays;

public class One_Code {
    public static void main(String[] args) {
        int[] arr = {9, 7, 8, 1, 6, 3, 5, 4, 2};
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void cycleSort(int[] arr) {
        int i = 0;
        while (i < arr.length - 1) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int max, int last) {
        int temp = arr[max];
        arr[max] = arr[last];
        arr[last] = temp;
    }
}
