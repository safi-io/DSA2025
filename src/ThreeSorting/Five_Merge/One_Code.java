package ThreeSorting.Five_Merge;

import java.util.*;

public class One_Code {
    public static void main(String[] args) {
        int[] arr = {10, 2, 30, 4, 11, 30, 3, 1, 20, 40};
        System.out.println("U"+ Arrays.toString(arr));
        merge(arr, 0, arr.length - 1);
        System.out.println("S"+ Arrays.toString(arr));

    }

    private static void merge(int[] arr, int start, int end) {
        if(start<end) {
            int mid = start + (end-start) /2;

            merge(arr, start, mid);
            merge(arr, mid+1, end);

            mergeSort(arr, start, mid, end);
        }
    }


    private static void mergeSort(int[] arr, int start, int mid, int end) {

        ArrayList<Integer> temp = new ArrayList<>();

        int i = start, j = mid+1;

        while(i<=mid && j<=end) {
            if(arr[i] <= arr[j]) {
                temp.add(arr[i]);
                i++;
            }else {
                temp.add(arr[j]);
                j++;
            }
        }

        while(i<=mid) {
            temp.add(arr[i]);
            i++;
        }

        while(j<=end) {
            temp.add(arr[j]);
            j++;
        }

        for(int index = 0; index <temp.size(); index++) {
            arr[index+start] = temp.get(index);
        }

    }
}


