import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int tarSum = scn.nextInt();

        int[] dp = new int[tarSum + 1];

        dp[0] = 1; // because there is one way to print zero as well.

        // filling the dp array.
        for (int i = 0; i < arr.length; i++) { // running this parent for loop for coins.
            for (int j = arr[i]; j < dp.length; j++) { // accessing the coins, and running it from the respective
                                                       // indexes in the dp array.
                dp[j] += dp[j - arr[i]];
            }
        }
        // int sol = dp.length - 1;
        System.out.println(dp[dp.length - 1]);
    }
}
