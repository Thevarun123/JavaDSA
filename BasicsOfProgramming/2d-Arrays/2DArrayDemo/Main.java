import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner take = new Scanner(System.in);
        int n = take.nextInt();
        int m = take.nextInt();

        int[][] box = new int[n][m];
        // Inputting the values.
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                box[i][j] = take.nextInt();
            }
        }
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                System.out.print(box[i][j] + " ");
            }
            System.out.println();
        }
    }

}