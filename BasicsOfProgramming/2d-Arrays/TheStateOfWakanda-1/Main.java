import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner take = new Scanner(System.in);
        int r1 = take.nextInt();
        int c1 = take.nextInt();
        int[][] arr = new int[r1][c1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = take.nextInt();
            }
        }
        // Checking the column value.
        for (int j = 0; j < arr[0].length; j++) {
            if (j % 2 == 0) { // row ++.
                for (int i = 0; i < arr.length; i++) {
                    System.out.println(arr[i][j]);
                }
            } else { // row--.
                for (int i = arr.length - 1; i >= 0; i--) {
                    System.out.println(arr[i][j]);
                }
            }
        }
    }
}