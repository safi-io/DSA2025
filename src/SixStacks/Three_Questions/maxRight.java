package SixStacks.Three_Questions;

import java.util.Arrays;
import java.util.Stack;

public class maxRight {
    public static void main(String[] args) {
        int[] height = {4, 2, 0, 5, 2, 6, 2, 3};   //      73,73,9,9,0

        Stack<Integer> maxRightStack = new Stack<>();
        maxRightStack.push(height[height.length - 1]);

        int[] maxRight = new int[height.length];
        maxRight[height.length - 1] = 0;

        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = maxRightStack.peek();
            if (!maxRightStack.isEmpty() && maxRightStack.peek() < height[i]) {
                maxRightStack.pop();
                maxRightStack.push(height[i]);
            }
        }

        System.out.println(Arrays.toString(maxRight));
    }
}
