package FourStrings.Questions;

public class appendUnSolved {
    public static void main(String[] args) {
        System.out.println(strWithout3a3b(2, 5));
    }

    public static String strWithout3a3b(int a, int b) {

        StringBuilder result = new StringBuilder();

        boolean isA = a > b;

        while (true) {
            if (isA) {
                if (a > 0) {
                    result.append("a".repeat(Math.min(2, a)));
                    a -= Math.min(2, a);
                    isA = false;
                }
            } else {
                if (b > 0) {
                    result.append("b".repeat(Math.min(2, b)));
                    b -= Math.min(2, b);
                    isA = true;
                }
            }
            if (a <= 0 && b <= 0) {
                return result.toString();
            }
        }
    }
}
