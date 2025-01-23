package OneArray.Questions;

public class prime {
    public static void main(String[] args) {
        int number = 18;
        System.out.print(isPrime(number));
    }

    static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = number - 1; i > 1; i--) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
