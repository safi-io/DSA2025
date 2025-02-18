package SixStacks.Three_Questions;

import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElementCircular {
    public static void main(String[] args) {
        int[] nums = {1, 2, -1};  // Expected Output: [2, -1, 2]
        int[] result = ngec(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] ngec(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        // Traverse the array twice (simulate circular behavior)
        for (int i = 2 * n - 1; i >= 0; i--) {
            int index = i % n;

            // Pop smaller or equal elements
            while (!st.isEmpty() && st.peek() <= nums[index]) {
                st.pop();
            }

            // Assign the next greater element
            result[index] = st.isEmpty() ? -1 : st.peek();

            // **Push AFTER processing** to avoid immediate reusing
            st.push(nums[index]);
        }

        return result;
    }
}
