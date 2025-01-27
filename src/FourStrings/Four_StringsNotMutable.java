package FourStrings;

public class Four_StringsNotMutable {
    public static void main(String[] args) {
        String result = "";
        String temp = result;

        System.out.println(result == temp);

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('A' + i);
            result += ch;
        }

        System.out.println(result);
        System.out.println(result == temp);


    }
}
