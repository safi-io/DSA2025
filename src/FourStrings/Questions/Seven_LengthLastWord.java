package FourStrings.Questions;

public class Seven_LengthLastWord {
    public static void main(String[] args) {
        String str = "   fly me   to   the moon  ";
        String[] strArr = str.strip().split(" ");
        int length = strArr[strArr.length - 1].length();
        System.out.println(length);
    }
}
