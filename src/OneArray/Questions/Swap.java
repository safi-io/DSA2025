package OneArray.Questions;

import java.util.Arrays;

public class Swap {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        // TODO : Have to change 2nd index to 3
        change(arr,1,3); // Pass by reference

        System.out.println(Arrays.toString(arr));
    }

    private static void change(int[] arr, int index, int index2) {
        int temp = arr[index];
        arr[index] = arr[index2];
        arr[index2] = temp;
    }
}
