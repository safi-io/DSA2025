package FourStrings.Questions;

public class Ten_findDifference {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s, t));
    }

    public static char findTheDifference(String s, String t) {
        int[] hashedArr = new int[26];

        for (int i = 0; i < t.length(); i++) {
            int value = t.charAt(i) - 97;
            hashedArr[value]++;
        }


        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i) - 97;
            hashedArr[value]--;
        }


        for (int i = 0; i < hashedArr.length; i++) {
            if (hashedArr[i] > 0) {
                System.out.println((char)(i+97));
            }
        }

        return 'S';

    }
}
