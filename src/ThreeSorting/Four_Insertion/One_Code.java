package ThreeSorting.Four_Insertion;

import java.util.Arrays;

public class One_Code {
    public static void main(String[] args) {
        int[] arr = {3,2,5,4};
        insertionSort(arr);
            System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }


}

