package OneArray.Questions;

import java.util.Arrays;

public class Concatenation {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 1};

//        int arrSize = nums.length;
//        int tempSize = arrSize;

//        int[] finalArr = new int[arrSize * 2];

//        for (int i = 0; i < finalArr.length; i++) {
//            if (i < arrSize) {
//                finalArr[i] = nums[i];
//            } else {
//                break;
//            }
//        }

//        for (int i = arrSize; i < finalArr.length; i++) {
//            finalArr[i] = nums[arrSize - tempSize];
//            tempSize--;
//        }

        // OR

        int[] nums = {1, 2, 1};
        int arrSize = nums.length;
        int[] finalArr = new int[arrSize * 2];

        System.arraycopy(nums, 0, finalArr, 0, arrSize);
        System.arraycopy(nums, 0, finalArr, arrSize, arrSize);
        System.out.println(Arrays.toString(finalArr));

    }
}
