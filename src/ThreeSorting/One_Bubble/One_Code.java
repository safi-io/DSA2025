package ThreeSorting.One_Bubble;

import java.util.Arrays;

public class One_Code {
    public static void main(String[] args) {
        int[] arr = {7,9,7,4,2,8,7,7,1,5};

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) { // Simplify the loop condition
                if (arr[j] > arr[j + 1]) {
                    // Swap adjacent elements if they are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                // If no swaps were made in the current pass, the array is sorted
                break;
            }
        }
    }

}
