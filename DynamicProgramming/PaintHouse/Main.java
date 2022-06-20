import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int houses = scn.nextInt();

        int[][] localArea = new int[houses][3];

        for (int houseNo = 0; houseNo < localArea.length; houseNo++) {
            for (int paint = 0; paint < localArea[0].length; paint++) {
                localArea[houseNo][paint] = scn.nextInt(); // tell the price of painting that particular house in different
            }
        }
        long[][] dp = new long[houses][3];
        dp[0][0] = localArea[0][0];
        dp[0][1] = localArea[0][1];
        dp[0][2] = localArea[0][2];

        for (int i = 1; i < dp.length; i++) {

            dp[i][0] = localArea[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = localArea[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = localArea[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);

        }
        System.out.println(Math.min(dp[dp.length - 1][0], Math.min(dp[dp.length - 1][1], dp[dp.length - 1][2])));
    }
}
