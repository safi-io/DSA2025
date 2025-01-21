package OneArray.Questions;

import java.util.ArrayList;

public class validPalindrome {
    public static void main(String[] args) {
        String s = "0P";
        String lowerCase = s.toLowerCase();
        ArrayList<Character> charactersArray = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (lowerCase.charAt(i) != ' ' && ((int) lowerCase.charAt(i) >= 97 && (int) lowerCase.charAt(i) <= 122) || (lowerCase.charAt(i) >= 48 && lowerCase.charAt(i) <= 57)) {
                charactersArray.add(lowerCase.charAt(i));
            }
        }

        ArrayList<Character> reverseCharactersArray = new ArrayList<>(charactersArray.size());

        for (int i = charactersArray.size() - 1; i >= 0; i--) {
            reverseCharactersArray.add(charactersArray.get(i));
        }


        for (int i = 0; i < charactersArray.size(); i++) {
            if (charactersArray.get(i) != reverseCharactersArray.get(i)) {
                System.out.print("NOT A PALINDROME");
                break;
            }
        }
    }
}
