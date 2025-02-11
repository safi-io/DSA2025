package SixStacks.Three_Questions;

import java.util.Stack;

public class singleValidParenthesis {

    private static boolean isValid(String data) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '(') {
                st.push('(');
            } else {
                if (st.isEmpty()) {
                    return false;
                } else {
                    st.pop();

                }
            }
        }

      return st.isEmpty();

    }

    public static void main(String[] args) {
        String parenthesis = "()";
        System.out.println(isValid(parenthesis));
    }
}
