package OneArray.Questions;

import java.util.Scanner;

public class Max {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the size of Array:");
        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("The Maximum Number is: " + maxNumber(arr));

    }

    private static int maxNumber(int[] arr) {
        int max = -1;
        for (int number : arr) {
            if (number > max) max = number;
        }
        return max;
    }
}
