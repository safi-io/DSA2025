package SixStacks.Three_Questions;

import java.lang.classfile.constantpool.IntegerEntry;
import java.util.Arrays;
import java.util.Stack;

public class largestRectangleHistogram {
    public static void main(String[] args) {
        int[] height = {2, 3, 4, 2, 6, 5, 4, 5, 3};
        System.out.println(lrh(height));
    }

    private static int lrh(int[] height) {
        int[] nextSmallestRight = nsr(height);
        int[] nextSmallestLeft = nsl(height);

        int rect = 0;

        for (int i = 0; i < height.length; i++) {
            height[i] = height[i] * (nextSmallestRight[i] - nextSmallestLeft[i] - 1);
            if (height[i] > rect) {
                rect = height[i];
            }
        }

        return rect;
    }

    private static int[] nsr(int[] height) {
        int[] toReturn = new int[height.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            while (!st.isEmpty() && height[st.peek()] > height[i]) {
                toReturn[st.peek()] = i;
                st.pop();
            }

            st.push(i);
        }

        while (!st.isEmpty()) {
            toReturn[st.pop()] = height.length;
        }

        return toReturn;
    }

    private static int[] nsl(int[] height) {
        int[] toReturn = new int[height.length];
        Stack<Integer> st = new Stack<>();

        for (int i = height.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && height[st.peek()] > height[i]) {
                toReturn[st.peek()] = i;
                st.pop();
            }

            st.push(i);

        }

        while (!st.isEmpty()) {
            toReturn[st.pop()] = -1;
        }

        return toReturn;
    }
}
