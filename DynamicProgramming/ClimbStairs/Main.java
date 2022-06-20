import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int cp = countPathsTab(n);
        System.out.println(cp);
    }

    // Tabulation method
    public static int countPathsTab(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1; // because 0 to 0 is only 1 path.
        for (int i = 1; i <= n; i++) { // we are storing the count of paths, from the current index to index 0 in the
                                       // corresponding index values.
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }

    // Memoization method
    public static int countPathsMemoization(int n, int[] qb) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        if (qb[n] > 0) {
            return qb[n];
        }

        // calls
        int cp1 = countPathsMemoization(n - 1, qb);
        int cp2 = countPathsMemoization(n - 2, qb);
        int cp3 = countPathsMemoization(n - 3, qb);
        int cp = cp1 + cp2 + cp3;

        qb[n] = cp;
        return cp;
    }
}
