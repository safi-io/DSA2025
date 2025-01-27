package FourStrings;

public class Five_StringBuilders {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = result;

        for (int i = 0; i < 26; i++) {
            result.append((char) ('A' + i));
        }

        System.out.println(result);
        System.out.println(result == temp); // True, Because StringBuilder is mutable
    }
}
