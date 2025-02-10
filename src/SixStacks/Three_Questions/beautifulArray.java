package SixStacks.Three_Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class beautifulArray {
    public static ArrayList<Integer> makeBeautiful(int[] arr) {
        // Let's make a stack
        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (st.isEmpty()) {
                st.push(arr[i]);
                // Non Negative
            } else if (arr[i] >= 0) {

                // Negative
                if (st.peek() < 0) {
                    st.pop();
                } else {
                    st.push(arr[i]);
                }
                // Negative
            } else {
                if (st.peek() < 0) {
                    st.push(arr[i]);
                } else {
                    st.pop();
                }

            }

        }

        ArrayList<Integer> toReturn = new ArrayList<>(st);


        return toReturn;


    }

    public static void main(String[] args) {
        int[] arr = {-3, -1, -19, 0, 6, -13, 12};
        System.out.println(makeBeautiful(arr));
    }
}
