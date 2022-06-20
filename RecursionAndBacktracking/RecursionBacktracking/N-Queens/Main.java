import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] chess = new int[n][n];
        printNQueens(chess, "", 0);
    }

    public static boolean IsItSafeToPlace(int[][] chess, int row, int col) {
        // vertical up check
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        // diagonal up-left check
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        // diagonal up-right check
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        // baseCase
        if (row == chess.length) {
            System.out.println(qsf + "."); // print
            return;
        }

        for (int col = 0; col < chess.length; col++) {
            if (IsItSafeToPlace(chess, row, col) == true) {
                chess[row][col] = 1; // left side of the edge in tree depiction
                printNQueens(chess, qsf + row + "-" + col + "," + " ", row + 1);
                chess[row][col] = 0;
            }
        }
    }
}