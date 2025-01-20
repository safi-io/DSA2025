package OneArray;

import java.util.Arrays;
import java.util.Scanner;

public class Two_2DArrays {
    public static void main(String[] args) {
        // Jagged Array(See notes)
        int[][] arr = new int[2][];
        arr[0] = new int[3];
        arr[1] = new int[2];

        Scanner sc = new Scanner(System.in);

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = sc.nextInt();
            }

//            for(int number :  arr[row]) {  // will not work, because (number variable) is copy, not refernce
//                number = sc.nextInt();
//            }
        }

        for (int row = 0; row < arr.length; row++) {
            System.out.println(Arrays.toString(arr[row]));
        }

        int[][] arrayCom = {{1, 2, 3, 4, 5,}, {10, 20, 30, 40, 50},};

    }
}
