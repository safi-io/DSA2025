package ThreeSorting.Three_Cycle.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findAllNumberDisappeared {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(arr);
        System.out.println(disappearedNumbers);
    }

    static List<Integer> findDisappearedNumbers(int[] arr) {
        List<Integer> result = new ArrayList<>();

        // sort the arr
        cycleSort(arr);

        // Find Disappeared One's
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                result.add(i + 1);
            }
        }
        System.out.println(Arrays.toString(arr));

        return result;
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

    private static void swap(int[] arr, int max, int last) {
        int temp = arr[max];
        arr[max] = arr[last];
        arr[last] = temp;
    }
}


