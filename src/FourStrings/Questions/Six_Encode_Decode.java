package FourStrings.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Six_Encode_Decode {

    public static void main(String[] args) {

        List<String> str = List.of(new String[]{"HELLO-WORLD", "", "PAKISTAN"});

        String encodedString = encode(str);
        System.out.println(decode(encodedString));
    }

    public static String encode(List<String> strs) {
        List<String> str = strs;

        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < str.size(); i++) {
            rs.append(str.get(i).length() + ":" + str.get(i));
        }

        return rs.toString();
    }

    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            // Find the position of the next colon
            int colonIndex = str.indexOf(':', i);

            // Extract the length (from current index to colon)
            int length = Integer.parseInt(str.substring(i, colonIndex));

            // Extract the string based on the length
            String extractedString = str.substring(colonIndex + 1, colonIndex + 1 + length);

            // Add the string to the result list
            result.add(extractedString);

            // Move the index to the next string's metadata
            i = colonIndex + 1 + length;
        }

        return result;
    }


}
