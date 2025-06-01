package Assignments.Theory_Four;

import java.util.ArrayList;

public class MergeSortTransaction {
    public static void merge(Transaction[] arr, int start, int end) {
        if (arr == null || arr.length == 0) return;

        if (start < end) {
            int mid = start + (end - start) / 2;

            merge(arr, start, mid);
            merge(arr, mid + 1, end);

            mergeSort(arr, start, mid, end);

        }
    }

    private static void mergeSort(Transaction[] transactions, int start, int mid, int end) {
        ArrayList<Transaction> temp = new ArrayList<>();

        int i = start;
        int j = mid + 1;

        while (i <= mid && j <= end) {
            if (transactions[i].getAmount() < transactions[j].getAmount()) {
                temp.add(transactions[i]);
                i++;
            } else {
                temp.add(transactions[j]);
                j++;
            }
        }

        while (i <= mid) {
            temp.add(transactions[i]);
            i++;
        }

        while (j <= end) {
            temp.add(transactions[j]);
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            transactions[k + start] = temp.get(k);
        }
    }
}
