package ThreeSorting.Two_Selection;

import java.util.Arrays;

public class One_Code {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 0, 2, 1, -12};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            int lastIndex = size - i - 1;
            int maxIndex = maxIndex(arr, 0, lastIndex);
            swap(arr, maxIndex, lastIndex);
        }
    }

    private static void swap(int[] arr, int max, int last) {
        int temp = arr[max];
        arr[max] = arr[last];
        arr[last] = temp;
    }

    private static int maxIndex(int[] arr, int start, int end) {
        int max = start;

        for (int i = start; i < end; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }

        return max;
    }

}
