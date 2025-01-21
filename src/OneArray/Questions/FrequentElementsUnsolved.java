package OneArray.Questions;

import java.util.Arrays;

public class FrequentElementsUnsolved {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3, 4, 9};
        int[] hashed = new int[10];

        System.out.println(Arrays.toString(hashed));

        for (int i = 0; i < arr.length; i++) {
            hashed[ arr[i] ]++;
        }

        System.out.println(Arrays.toString(hashed));

    }
}
