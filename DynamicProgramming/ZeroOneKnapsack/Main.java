import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] reqBall = new int[n];
        for (int i = 0; i < reqBall.length; i++) {
            reqBall[i] = scn.nextInt();
        }

        int[] runs = new int[n];
        for (int i = 0; i < runs.length; i++) {
            runs[i] = scn.nextInt();
        }

        int maxRun = scn.nextInt();

        int[][] dp = new int[n + 1][maxRun + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j >= reqBall[i - 1]) {
                    if ((runs[i - 1] + dp[i - 1][j - reqBall[i - 1]]) > dp[i - 1][j]) {
                        dp[i][j] = runs[i - 1] + dp[i - 1][j - reqBall[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j]; // when i doesn't bat.
                    }
                } else {
                    dp[i][j] = dp[i - 1][j]; // when i doesn't bat.
                }
            }
        }
        System.out.println(dp[n][maxRun]);
    }
}
