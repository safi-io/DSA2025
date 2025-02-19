package SixStacks.Three_Questions;

import java.util.Arrays;
import java.util.Stack;

public class maxLeft {
    public static void main(String[] args) {
        int[] height = {4, 2, 0, 5, 2, 6, 2, 3};
        Stack<Integer> maxLeftStack = new Stack<>();
        maxLeftStack.push(height[0]);

        int[] maxLeft = new int[height.length];
        maxLeft[0] = 0;

        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = maxLeftStack.peek();

            if (!maxLeftStack.isEmpty() && maxLeftStack.peek() < height[i]) {
                maxLeftStack.pop();
                maxLeftStack.push(height[i]);
            }
        }


        System.out.println(Arrays.toString(maxLeft));

    }
}
