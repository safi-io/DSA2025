package ThreeSorting.Five_Merge;

import java.util.Arrays;

public class One_Code {

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);  // Left Portion of Array
            mergeSort(arr, mid + 1, right); // Right Portion of Array

            // Merge Sorted Halves
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary Arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);

        int i = 0;
        int j = 0;
        int index = left;

        while (i < n1 && j < n2) {

            if (leftArray[i] <= rightArray[j]) {
                arr[index] = leftArray[i];
                i++;
            } else {
                arr[index] = rightArray[j];
                j++;
            }
            index++;
        }

        while (i < n1) {
            arr[index] = leftArray[i];
            i++;
            index++;
        }

        while (j < n2) {
            arr[index] = rightArray[j];
            j++;
            index++;
        }

    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 30, 4, 11, 3, 1, 20, 40};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
