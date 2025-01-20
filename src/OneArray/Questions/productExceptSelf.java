package OneArray.Questions;

import java.util.Arrays;

public class productExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
//        ArrayList<Integer> toConvert = new ArrayList<Integer>();
//
//        for (int i = 0; i < nums.length; i++) {
//            int product = 1;
//            for (int j = 0; j < nums.length; j++) {
//                if (i == j) continue;
//                product *= nums[j];
//            }
//            toConvert.add(product);
//        }
//
//        System.out.println(toConvert);

        int[] prefix = new int[nums.length];
        prefix[0] = 1;

        int[] suffix = new int[nums.length];
        suffix[nums.length-1] = 1;


        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        for (int i = nums.length-2; i >=0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }


        System.out.println(Arrays.toString(prefix));
        System.out.println(Arrays.toString(suffix));

        int[] toDisplay = new int[nums.length];
        for(int i=0; i< toDisplay.length; i++) {
            toDisplay[i] = suffix[i]  * prefix[i];
        }

        System.out.println(Arrays.toString(toDisplay));
        // Output: [24, 12,8,6]
    }
}
