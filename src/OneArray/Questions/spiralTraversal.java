package OneArray.Questions;

public class spiralTraversal {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3,4}, {5, 6,7,8}, {9,10,11,12}};

        int m = arr.length; // Row Length
        int n = arr[0].length; // Column Length

        int sRow = 0;
        int sCol = 0;

        int eRow = m - 1;
        int eCol = n - 1;

        while (sRow <= eRow && sCol <=eCol) {
            for (int i = sCol; i <= eCol; i++) {
                System.out.print(arr[sRow][i] + " ");
            }

            for (int i = sRow + 1; i <= eRow; i++) {
                System.out.print(arr[i][eCol] + " ");
            }
            if(sRow==eRow) {
                return;
            }
            for (int i = eCol - 1; i >= sCol; i--) {
                System.out.print(arr[eRow][i] + " ");
            }


            for (int i = eRow - 1; i >= sRow + 1; i--) {
                System.out.print(arr[i][sCol] + " ");
            }
            sRow++;
            eRow--;
            sCol++;
            eCol--;
        }


    }
}


// 1,2,3,6,9,8,7,4,1