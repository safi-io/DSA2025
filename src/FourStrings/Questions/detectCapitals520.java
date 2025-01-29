package FourStrings.Questions;

public class detectCapitals520 {
    public static void main() {
        System.out.println(detectCapitalUse("flAg"));
    }

    public static boolean detectCapitalUse(String word) {
        // Checking if all letters are capital
        boolean allCapital = true;

        for (int i = 0; i < word.length(); i++) {
            int ASCII = word.charAt(i);
            if (!(ASCII >= 65 && ASCII <= 90)) {
                allCapital = false;
                break;
            }
        }

        if (allCapital) {
            return true;
        }

        boolean allSmall = true;
        // Checking if all letters are small
        for (int i = 0; i < word.length(); i++) {
            int ASCII = word.charAt(i);
            if (!(ASCII >= 97 && ASCII <= 122)) {
                allSmall = false;
                break;
            }
        }

        if (allSmall) {
            return true;
        }

        // Checking if first letter is Capital, and all others smaller

        int firstLetterASCII = word.charAt(0);
        if (firstLetterASCII >= 65 && firstLetterASCII <= 90) {
            for (int i = 1; i < word.length(); i++) {
                int ASCII = word.charAt(i);
                if (!(ASCII >= 97 && ASCII <= 122)) {
                    return false;
                }
            }
        }else {
            return false;
        }

        return true;
    }
}
