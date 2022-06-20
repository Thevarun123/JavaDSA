import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner take = new Scanner(System.in);
        int n = take.nextInt();
        int[][] arr = new int[n][n];
        // Inputing in the array.
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = take.nextInt();
            }
        }
        // Accessing the row to initialise the min element i.e arr[i][j] --> i =0 and j
        // =0;
        for (int i = 0; i < arr.length; i++) {
            // We will apply linear search also to get our saddle price.
            int min = 0;
            int psj = 0;// Creating a potential saddle price.
            min = arr[i][psj];
            for (int j = 1; j < arr[0].length; j++) {
                if (min > arr[i][j]) {// If the value at arr index is lower than the min values than push that
                                      // corresponding value into min.
                    min = arr[i][j];
                    psj = j;
                }
            }
            boolean flag = true;
            for (int k = 1; k < arr.length; k++) {
                if (min < arr[k][psj]) {
                    flag = false;
                }
            }
            if (flag == true) {
                System.out.println(min);
                return;
            }
        }
        System.out.println("Invalid input");
    }

}