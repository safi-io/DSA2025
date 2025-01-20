package OneArray.Questions;

import java.util.Arrays;

public class RunningSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
//
//        int[] toReturnArr = new int[nums.length];
//
//        for(int i=0; i<toReturnArr.length; i++) {
//            toReturnArr[i] = sum(nums, i);
//        }

//        System.out.println(sum(nums,1));


        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        System.out.println(Arrays.toString(nums));



    }

    private static int sum(int[] arr, int end) {
        int sum = 0;

        for (int i = 0; i <= end; i++) {
            sum += arr[i];
        }

        return sum;
    }
}
