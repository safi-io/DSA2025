package SixStacks.Three_Questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class nextGreaterElem {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2};
        int[] subArr = {1, 2};

        int[] result = nge(subArr, arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] nge(int[] subArr, int[] arr) {
        int[] result = new int[subArr.length];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int index = arr.length - 1; index >= 0; index--) {

            while (!st.isEmpty() && arr[index] > st.peek()) {
                st.pop();
            }

            map.put(arr[index], st.isEmpty() ? -1 : st.peek());
            st.push(arr[index]);
        }

        for (int i = 0; i < subArr.length; i++) {
            result[i] = map.getOrDefault(subArr[i], -1);
        }
        return result;
    }

}
