package SixStacks.Three_Questions;

import java.util.Objects;
import java.util.Stack;

public class folderCrawler {
    public static void main(String[] args) {
        System.out.println(minOperations( new String[]{"d1/", "d2/", "../", "d21/", "./"}));
    }

    public static int minOperations(String[] logs) {
        Stack<Integer> st = new Stack<>();

        for (String log : logs) {
            // If the log is to move to Child Folder
            if (!Objects.equals(log.charAt(0), ".")) {
                st.push(1);
            } else if (Objects.equals(log.charAt(0), ".") && Objects.equals(log.charAt(1), ".")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            }
        }

        int toReturn = 0;

        while (!st.isEmpty()) {
            toReturn += st.pop();
        }

        return toReturn;


    }
}
