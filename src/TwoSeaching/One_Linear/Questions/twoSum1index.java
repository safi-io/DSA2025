package TwoSeaching.One_Linear.Questions;

import java.util.Arrays;

public class twoSum1index {
    public static void main(String[] args) {
        int[] numbers = {0,0,3,4};
        int target = 0;
        int[] toReturn = new int[2];

        outer:
        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                if(numbers[i]+numbers[j]==target) {
                    toReturn[0] = i+1;
                    toReturn[1] = j+1;
                    break outer;
                }
            }
        }

        System.out.println(Arrays.toString(toReturn));
    }
}
