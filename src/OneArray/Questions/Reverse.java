package OneArray.Questions;

import java.util.Arrays;

import static OneArray.Questions.Swap.change;

public class Reverse {
    public static void main(String[] args) {
        int arr[] = {1, 2, 30, 4, 5};
        System.out.println(Arrays.toString(arr));

        reverse(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static int[] reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            // Two Pointer Methodc
            change(arr, start, end);
            start++;
            end--;
        }

        return arr;
    }

}
