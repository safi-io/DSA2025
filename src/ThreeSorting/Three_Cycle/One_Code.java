package ThreeSorting.Three_Cycle;

import java.util.Arrays;

public class One_Code {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));


    }

    static void cycleSort(int[] array) {
        int currentIndex = 0;

        while (currentIndex < array.length) {
            int correctIndex = array[currentIndex]-1;

            if (array[currentIndex] != array[correctIndex]) {
                swap(array, currentIndex, correctIndex);
            } else {
                currentIndex++;
            }
        }
    }


    private static void swap(int[] arr, int max, int last) {
        int temp = arr[max];
        arr[max] = arr[last];
        arr[last] = temp;
    }
}
