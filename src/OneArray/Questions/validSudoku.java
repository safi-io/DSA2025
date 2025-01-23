package OneArray.Questions;

import java.util.Arrays;

public class validSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(searchBoard(board));
    }

    static boolean searchBoard(char[][] board) {
        int[] hashed = new int[10];


        // Check Rows
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    hashed[(int) (board[i][j]) - '0']++;
                }
            }


            for (int k = 1; k < hashed.length; k++) {
                if (hashed[k] > 1) {
                    return false;
                }
            }
            Arrays.fill(hashed, 0);
        }


        // Check Columns
        for (int j = 0; j < board[0].length; j++) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != '.') {
                    hashed[((int) (board[i][j])) - '0']++;
                }
            }

            for (int k = 1; k < hashed.length; k++) {
                if (hashed[k] > 1) {
                    return false;
                }
            }
            Arrays.fill(hashed, 0);
        }

        // Check 9 (3*3)Boxes
        // Check 3×3 Sub-Boxes
        for (int startRow = 0; startRow < board.length; startRow += 3) {
            for (int startCol = 0; startCol < board.length; startCol += 3) {
                Arrays.fill(hashed, 0); // Reset hashed array for the current sub-box

                // Iterate through the 3×3 sub-box
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int row = startRow + i;
                        int col = startCol + j;

                        // If cell is not empty, process it
                        if (board[row][col] != '.') {
                            int num = board[row][col] - '0'; // Convert char to digit
                            hashed[num]++;
                            if (hashed[num] > 1) {
                                return false; // Duplicate found in the sub-box
                            }
                        }
                    }
                }
            }
        }


        return true;
    }
}
