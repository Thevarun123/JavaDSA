import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt(); // enter the no of transactions.

        int[][] dp = new int[k + 1][n];
        // the optimised approach
        for (int t = 1; t <= k; t++) {
            int max = Integer.MIN_VALUE;

            for (int d = 1; d < dp[0].length; d++) {
                if (dp[t - 1][d - 1] - arr[d - 1] > max) {
                    max = dp[t - 1][d - 1] - arr[d - 1];
                }

                // settle max
                if (max + arr[d] > dp[t][d - 1]) {
                    dp[t][d] = max + arr[d];
                } else {
                    dp[t][d] = dp[t][d - 1];
                }
            }
        }
        System.out.println(dp[k][n - 1]);

        // the n-cube approach (not optimised at all)

        // for (int t = 1; t < dp.length; t++) {
        // for (int d = 1; d < dp[0].length; d++) {
        // int max = dp[t][d - 1];

        // loop will run for calculating the other transactions done on before days with
        // one transaction less from the current day.
        // for (int pd = 0; pd < d; pd++) { // pd = pastDays
        // int diff = arr[d] - arr[pd];
        // int add = dp[t][pd] + diff;

        // if (add > max) {
        // dp[t][d] = add;
        // } else {
        // dp[t][d] = max;
        // }
        // } // also try to run pd in reverse order
        // }
        // }
        // System.out.println(dp[k][n - 1]);
    }

}