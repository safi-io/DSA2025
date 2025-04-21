package Assignments;

public class fibonannci {
    public static void main(String[] args) {
        int n = 10; // Number of terms
        for (int i = 0; i < n; i++) {
            System.out.print(fibo(i) + " ");
        }
    }

    private static int fibo(int n) {
        if (n < 2) {
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
}
