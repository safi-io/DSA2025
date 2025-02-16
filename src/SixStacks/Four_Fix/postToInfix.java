package SixStacks.Four_Fix;

import java.util.Stack;

public class postToInfix {
    public static void main(String[] args) {
        String statement = "ab*c+";
        System.out.println(convert(statement));
    }


    private static String convert(String statement) {

        Stack<String> st = new Stack<>();

        int size = statement.length(), i = 0;

        while (i < size) {

            if (isOperands(statement.charAt(i))) {
                st.push(String.valueOf(statement.charAt(i)));
            } else {
                if (!st.isEmpty()) {
                    String ch1 = st.pop();
                    String ch2 = st.pop();
                    String toPush = "(" +ch2 + statement.charAt(i) + ch1 + ")";
                    st.push(toPush);
                }
            }


            i++;
        }

        return st.pop();
    }

    private static boolean isOperands(char ch) {
        return ch >= 'a' && ch <= 'z' ||
                ch >= 'A' && ch <= 'Z' ||
                ch >= '0' && ch <= '9';
    }
}
