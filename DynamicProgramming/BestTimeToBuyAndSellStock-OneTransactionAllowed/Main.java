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

        int least = Integer.MAX_VALUE;
        int of = 0;
        int pist = 0;
        for (int i = 0; i < prices.length; i++) {
            // calculating the least
            if (prices[i] < least) {
                least = prices[i];
            }

            // profit if sold today.
            pist = prices[i] - least;

            // the overall profit (highest profit)
            if (pist > of) {
                of = pist;
            }

        }
        System.out.println(of);
    }

}