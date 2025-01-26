package ThreeSorting.Three_Cycle.Questions;

import java.util.Arrays;

public class findDuplicateOne {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));


    }

    static void cycleSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int max, int last) {
        int temp = arr[max];
        arr[max] = arr[last];
        arr[last] = temp;
    }

}
