package OneArray.Questions;

import java.util.Arrays;

public class countPrimes {
    public static void main(String[] args) {
        System.out.println(isPrime(10));
    }

    private static int isPrime(int n) {
        boolean[] mainArr = new boolean[n];
        Arrays.fill(mainArr, true);

        int count = 0;

        for(int i=2; i<n; i++) {
            if( !mainArr[i] ) {
                continue;
            }

            boolean isPrime = true;

            toExit:
            for(int j=i-1; j>=2; j--) {
                if( i % j ==0  ) {
                    isPrime = false;
                    break toExit;
                }
            }

            if(isPrime) {
                // i is bascially prime
                count++;
                int primeNumber = i;
                mainArr[primeNumber] = false;

                for(int k=primeNumber+1; k<n; k++) {
                    if( k % primeNumber ==0 ) {
                        mainArr[k] = false;
                    }
                }
            }

        }

        return count;

    }
}
