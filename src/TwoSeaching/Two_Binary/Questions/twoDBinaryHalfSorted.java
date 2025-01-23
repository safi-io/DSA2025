package TwoSeaching.Two_Binary.Questions;

public class twoDBinaryHalfSorted {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3}
        };
        int target = 3;
        System.out.println(searchMatrix(arr, target));
    }


    static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[row].length - 1;

        while (col >= 0 && row < matrix.length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }

        }

        return false;
    }
}


