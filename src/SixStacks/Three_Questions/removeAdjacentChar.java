package SixStacks.Three_Questions;

import java.util.Stack;

public class removeAdjacentChar {
    public static String removeDuplicates(String s) {
        if (s == "") return s;
        Stack<Character> st = new Stack<>();

        st.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if ( !st.isEmpty() && st.peek() == s.charAt(i)) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }
}
