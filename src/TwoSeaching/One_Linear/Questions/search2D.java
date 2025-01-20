package TwoSeaching.One_Linear.Questions;

import java.util.Arrays;

public class search2D {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int target = 8;
        System.out.println( "First is Row Number and Second is Column Number: \n" + Arrays.toString(twoDSearch(arr, target)) );

    }

    static int[] twoDSearch(int[][] arr, int target) {
        int[] toReturnArr = new int[2];
        Arrays.fill(toReturnArr, -1);

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                if(arr[i][j]==target) {
                    toReturnArr[0] = i;
                    toReturnArr[1] = j;
                    break;
                }
            }
        }

        return toReturnArr;
    }
}
