package SixStacks.Three_Questions;

import java.lang.classfile.constantpool.IntegerEntry;
import java.util.Arrays;
import java.util.Stack;

public class largestRectangleHistogram {
    public static void main(String[] args) {
        int[] height = {2, 1, 5, 6, 2, 3};
        System.out.println(lrh(height));
    }

    private static int lrh(int[] height) {
        int[] nextSmallestRight = nsr(height);
//        int[] nextSmallestLeft = nsl(height);
        System.out.println(Arrays.toString(nextSmallestRight));
        return -1;
    }

    private static int[] nsr(int[] height) {
        int[] toReturn = new int[height.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            while(!st.isEmpty() && height[st.peek()] > height[i] ) {
                toReturn[st.peek()] = i;
                st.pop();
            }

            if(st.isEmpty()) {

            }else {
            st.push(i);

            }

        }


        return toReturn;
    }

    private static int[] nsl(int[] height) {
    return new int[2];
    }
}
