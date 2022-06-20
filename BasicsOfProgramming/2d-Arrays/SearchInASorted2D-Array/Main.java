import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner take = new Scanner(System.in);
        int n = take.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = take.nextInt();
            }
        }

        int d = take.nextInt();
        // Implementing linear search.
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == d) {
                    System.out.println(i);
                    System.out.println(j);
                    return;
                }
            }
        }

        System.out.println("Not Found");
    }
}