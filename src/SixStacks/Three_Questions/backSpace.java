package SixStacks.Three_Questions;

import java.util.Stack;

public class backSpace {

    public static void main(String[] args) {
        String s = solvedSTR("a##c");
        String t = solvedSTR("#a#c");
        //        String t = solvedSTR("ad#c");
//        System.out.println(s.equals(t));
        System.out.println(s);
        System.out.println(t);
    }

    public static String solvedSTR(String s) {
        Stack<Character> st = new Stack<>();
//        st.push(s.charAt(0));
//        for (int i = 1; i < s.length(); i++) {
//            if (!st.isEmpty() && s.charAt(i) == '#') {
//                st.pop();
//            } else {
//                if (s.charAt(i) != '#') {
//                    st.push(s.charAt(i));
//                }
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        while (!st.isEmpty()) {
//            if (st.peek() != '#') {
//                sb.append(st.pop());
//            }else {
//                st.pop();
//            }
//        }

//        return sb.reverse().toString();
        System.out.println(st.size());
        return ";;";
    }
}
