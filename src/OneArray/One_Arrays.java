package OneArray;

import java.util.Arrays;

public class One_Arrays {
    public static void main(String[] args) {

        // Two ways of deceleration and initialization
        int[] nums = {1,2,3,4,5};
        System.out.println(nums[4]);

        int[] nums2 = new int[2];
        nums2[0] = 10;
        nums2[1] = 100;

        // For to input and output
        for(int i=0;i <nums2.length; i++) {
            System.out.println(nums2[i]);
        }

        // For Each
        for(int number : nums2) {
            System.out.print(number + " ");
        }

        // toString Mehtod
        System.out.println(Arrays.toString(nums2));
    }
}