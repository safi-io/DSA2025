package FourStrings.Questions;

public class One_Palindrome {
    public static void main(String[] args) {
        String example = "CIVIC";
        StringBuilder reverse = new StringBuilder();

        for (int i = example.length() - 1; i >= 0; i--) {
            reverse.append(example.charAt(i));
        }

        System.out.println(reverse.toString().equals(example));
    }
}
