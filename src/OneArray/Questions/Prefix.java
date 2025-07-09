package OneArray.Questions;

import java.util.Arrays;

public class Prefix {
    public static void main(String[] args) {
        int[] arr = {-2, 0, 3, -5, 2, -1};
        int[] result = computePrefixSum(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] computePrefixSum(int[] arr) {
        int[] result = new int[arr.length];
        if (arr.length == 0) return result;

        result[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result[i] = result[i - 1] + arr[i];
        }
        return result;
    }

}
