package SixStacks.Three_Questions;

import java.util.Arrays;

public class NGEright {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 1};
        int[] indices = {0,4 };

        int[] result = ngeRight(arr, indices);

        System.out.println(Arrays.toString(result));
    }

    private static int[] ngeRight(int[] arr, int[] indices) {

        // Optimise it Later

        int[] result = new int[indices.length];

        for (int i = 0; i < indices.length; i++) {
            int actualNumber = arr[indices[i]]; // 3
            int count = 0;
            for (int j = indices[i] + 1; j < arr.length; j++) {
                if (arr[j] > actualNumber) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }
}
