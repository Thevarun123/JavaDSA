import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] * (i - 1);
        }
        System.out.println(dp[n]);
    }

}

// // breif:
// the dp[n - 1] -> shows the number of ways a friend can remain single
// the dp[n - 2] -> shows the the number of ways a friend can remain in pair,
// the dp[n - 2] * (n - 1) -> shows the count of number of ways a friend can
// remain in pair with other friends