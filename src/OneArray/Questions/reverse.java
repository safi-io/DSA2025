package OneArray.Questions;

public class reverse {
    public static void main(String[] args) {
        int x = 1234236467;
        int result = returnReverse(x);
        System.out.println(result);
    }

    private static int returnReverse(int x) {
        boolean isNegative= false;

        if(x<0) {
            x *= -1;
            isNegative = true;
        }
        int result = 0;

        while (x != 0) {
            int remainder = x % 10;

            result = (result*10) + remainder;

            x /= 10;
        }

        if(isNegative) {
            result *= -1;
        }

        if(result > 2147483646 || result < -2147483647) return 0;

        return result;
    }


}
