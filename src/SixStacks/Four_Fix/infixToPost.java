package SixStacks.Four_Fix;

import java.util.Stack;

public class infixToPost {
    public static void main(String[] args) {
        String statement = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(convert(statement));
    }

    private static String convert(String statement) {
        StringBuilder result = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int size = statement.length();

        int i = 0;
        while (i < size) {
            // If it is an operand
            if (statement.charAt(i) >= 'a' && statement.charAt(i) <= 'z' ||
                    statement.charAt(i) >= 'A' && statement.charAt(i) <= 'Z' ||
                    statement.charAt(i) >= '0' && statement.charAt(i) <= '9'
            ) {
                result.append(statement.charAt(i));
            }
            // if it is an opening bracket
            else if (statement.charAt(i) == '(') {
                st.push(statement.charAt(i));
            }
            // if it is a closing bracket
            else if (statement.charAt(i) == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    result.append(st.pop());
                }
                st.pop();
            }
            // if it is an operator
            else {
                if (st.isEmpty()) {
                    st.push(statement.charAt(i));
                }
                else if (priority(statement.charAt(i)) > priority(st.peek())) {
                    st.push(statement.charAt(i));
                } else {
                    while (!st.isEmpty() && priority(statement.charAt(i)) <= priority(st.peek())) {
                        result.append(st.pop());
                    }
                    st.push(statement.charAt(i));
                }
            }

            i++;
        }
        while(!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.toString();
    }

    private static int priority(char ch) {
        if (ch == '^') {
            return 3;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        }

        return -1;
    }
}
