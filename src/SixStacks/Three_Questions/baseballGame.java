package SixStacks.Three_Questions;

import java.util.Objects;
import java.util.Stack;

public class baseballGame {
    public static void main(String[] args) {
        System.out.println( calPoint( new String[]{"1","C"}) );
    }

    private static int calPoint(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for (String operation : operations) {

            if (Objects.equals(operation, "C")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if (Objects.equals(operation, "D")) {
                if (!st.isEmpty()) {
                    int toDoubled = st.peek();
                    st.push(toDoubled * 2);
                }
            }else if (Objects.equals(operation, "+")) {
                if (!st.isEmpty()) {
                    int num1 = st.pop();
                    int num2 = st.peek();
                    st.push(num1);
                    st.push(num1+num2);
                }
            }else {
                st.push(Integer.parseInt(operation));
            }
        }

        int record = 0;
        while(!st.isEmpty()) {
            record += st.pop();
        }

        return record;
    }
}
