import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        int[] dp = new int[str.length()];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {

            // 0 0
            if (str.charAt(i - 1) == '0' && str.charAt(i) == '0') {
                dp[i] = 0;
                // 0 (1-9)
            } else if (str.charAt(i - 1) == '0' && str.charAt(i) != '0') {
                dp[i] = dp[i - 1];
                // (1-9) 0
            } else if (str.charAt(i - 1) != '0' && str.charAt(i) == '0') {
                if (Integer.parseInt(str.substring(i - 1, i + 1)) < 27) {
                    dp[i] = (i >= 2 ? dp[i - 2] : 1);
                } else {
                    dp[i] = 0;
                }
                // (1-9) (1-9)
            } else {
                if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                    // we need to be highly focued when applying the (i - 2) calls. As it will
                    // always check Arrayoutofbound error.
                    // (i >= 2 ? dp[i - 2] : 1) this condition basically check, that if the string
                    // is of only two characters,
                    // if it is then the possible string from that index will be only 1, just
                    // because,
                    // for ex. string -> "ta" is of only two characters, then it can encode 1
                    // possible way.
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        System.out.println(dp[str.length() - 1]);
    }
}
