package OneArray.Questions;

import java.util.Arrays;

public class sortColors {
    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 1, 2,0,0, 2, 0,1,1, 1, 2};
        int noOfZeros = 0;
        int noOfOnes = 0;
        int noOfTwos = 0;

        for (int number : nums) {
            if (number == 0) noOfZeros++;
            if (number == 1) noOfOnes++;
            if (number == 2) noOfTwos++;
        }

        int[] toReturn = new int[noOfZeros + noOfOnes + noOfTwos];

        for (int i = 0; i < noOfZeros; i++) {
            toReturn[i] = 0;
        }
        for (int i = noOfZeros; i < noOfZeros + noOfOnes; i++) {
            toReturn[i] = 1;
        }
        for (int i = noOfZeros + noOfOnes; i < nums.length; i++) {
            toReturn[i] = 2;
        }

        System.out.println(Arrays.toString(toReturn));
    }

}
