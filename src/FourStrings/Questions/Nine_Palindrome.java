package FourStrings.Questions;

public class Nine_Palindrome {
    public static void main(String[] args) {
        String s = "maham";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if (s.equals(" ")) return true;

        // Storing string in SB which is in lower-case and doesn't consist non-alphanumeric characters.
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = Character.toLowerCase(s.charAt(i));
            if (Character.isLetterOrDigit(currentChar)) {
                result.append(currentChar);
            }
        }

        // Using Two Pointer Method
        int i = 0;
        int j = result.length() - 1;
        while (i < result.length() / 2) {
            if (!(result.charAt(i) == result.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }

        return true;


    }
}
