package SixStacks.Three_Questions;

import java.util.Arrays;
import java.util.Stack;

public class previousSmallerElement {
    public static void main(String[] args) {
        int arr[] = {39, 27, 11, 4, 24, 32, 32, 1};


        int[] result = smallerElement(arr);

        System.out.println(Arrays.toString(result));
    }

    private static int[] smallerElement(int[] arr) {
        int[] result = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        result[0] = -1;
        st.push(arr[0]);

        for (int i = 1; i <= arr.length-1; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? -1 : st.peek();

            st.push(arr[i]);

        }

        return result;
    }
}
