import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int noc = scn.nextInt(); // noc -> number of coins

        int[] coins = new int[noc];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = scn.nextInt();
        }

        int tar = scn.nextInt();

        int[] dp = new int[tar + 1];

        dp[0] = 1;

        for (int amount = 0; amount < dp.length; amount++) {
            for (int coin : coins) { // it is more comprehensive to use this type of for loop inside the parent for
                                     // loop.
                if (coin <= amount) {
                    int call = amount - coin;
                    dp[amount] += dp[call];
                }
            }
        }
        System.out.println(dp[tar]);
    }
}
