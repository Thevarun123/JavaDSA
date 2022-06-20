import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = scn.nextInt();
        }

        int sd = 0;
        int bd = 0;
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sd++;
            } else { // handling both the cases i.e prices[i] == prices[i - 1] || prices[i] <
                     // prices[i - 1]
                profit += prices[sd] - prices[bd];
                sd = bd = i;
            }
        }
        profit += prices[sd] - prices[bd]; // to handle the last case
        System.out.println(profit);
    }

}