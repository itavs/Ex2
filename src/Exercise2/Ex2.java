package Exercise2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex2 {

    public static void findSaddlePoints(int[][] matrix) {

        int n = matrix.length, m = matrix[0].length; //Dimensions
        for (int i = 0; i < n; i++) {

            int minRowVal = matrix[i][0]; //Minimum value in current row
            int colIndex = 0; //Column index of minimum value

            for (int j = 1; j < m; j++) {

                // Find minimum value in the row
                if (matrix[i][j] < minRowVal) {
                    minRowVal = matrix[i][j];
                    colIndex = j;
                }
            }

            boolean saddlePoint = true; //Assume saddle point exists

            for (int k = 0; k < n; k++) {

                //Check if value is maximum in its column
                if (matrix[k][colIndex] > minRowVal) {
                    saddlePoint = false;
                    break;
                }
            }

            // Print saddle point
            if (saddlePoint) {
                System.out.println("Saddle point: " + minRowVal +
                        " at (" + i + "," + colIndex + ")");
            }
        }
    }

    public static String compressString(String str) {

        if (str == null) {
            return "";
        }

        return compressString(str, 0);
    }

    //Recursive helper method
    private static String compressString(String str, int i) {

        if (i == str.length() - 1) {
            return "" + str.charAt(i);
        }

        if (str.charAt(i) != str.charAt(i + 1)) {
            return str.charAt(i) + compressString(str, i + 1);
        }

        return compressString(str, i + 1);
    }

    public static int[][] generateMinesweeperHints(boolean[][] board) {

        if (board == null || board.length < 1 || board[0] == null) {
            throw new IllegalArgumentException("ERR : Invalid params");
        }
        int rows = board.length, cols = board[0].length;
        int[][] res = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (board[i][j] == true) {
                    res[i][j] = 1;

                } else {
                    int counter = 0; // Count neighboring mines

                    //Down
                    if (isValidNeighbour(i + 1, j, board)
                            && board[i + 1][j] == true) {
                        counter++;
                    }

                    //Up
                    if (isValidNeighbour(i - 1, j, board)
                            && board[i - 1][j] == true) {
                        counter++;
                    }

                    //Right
                    if (isValidNeighbour(i, j + 1, board)
                            && board[i][j + 1] == true) {
                        counter++;
                    }

                    //Left
                    if (isValidNeighbour(i, j - 1, board)
                            && board[i][j - 1] == true) {
                        counter++;
                    }

                    //Upper-left diagonal
                    if (isValidNeighbour(i - 1, j - 1, board)
                            && board[i - 1][j - 1] == true) {
                        counter++;
                    }

                    //Upper-right diagonal
                    if (isValidNeighbour(i - 1, j + 1, board)
                            && board[i - 1][j + 1] == true) {
                        counter++;
                    }

                    //Lower-left diagonal
                    if (isValidNeighbour(i + 1, j - 1, board)
                            && board[i + 1][j - 1] == true) {
                        counter++;
                    }

                    //Lower-right diagonal
                    if (isValidNeighbour(i + 1, j + 1, board)
                            && board[i + 1][j + 1] == true) {
                        counter++;
                    }

                    //Store neighbor mine count
                    res[i][j] = counter;
                }
            }
        }

        return res;
    }

//Helper method to identify legal or Illegal neighbour
    private static boolean isValidNeighbour(int i, int j, boolean[][] b) {
        return i >= 0 && i < b.length && j >= 0 && j < b[0].length;
    }
}
