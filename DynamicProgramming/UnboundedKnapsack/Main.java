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

        int tarBall = scn.nextInt();

        int[] dp = new int[tarBall + 1];
        dp[0] = 0; // runs on trial ball are always considered zero

        for (int i = 1; i < dp.length; i++) {
            int max = 0;

            for (int j = 0; j < reqBall.length; j++) {

                if (reqBall[j] <= i) {
                    int call = runs[j] + dp[i - reqBall[j]];

                    if (call > max) {
                        max = call;
                    }
                }
            }
            dp[i] = max;
        }
        System.out.println(dp[tarBall]);
    }
}
