import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        // buy and sell from the left towards right
        // constraint -> It is mandatory to sell today, and buy at the least buying
        // point before today.
        // also calculate the max buy-sell point if it present at today or before today.

        int mpist = 0;
        int least = arr[0];
        int[] dpl = new int[arr.length];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < least) {
                least = arr[i];
            }
            mpist = arr[i] - least;
            if (mpist > dpl[i - 1]) { // if today earned more money than the max buy-sell point before today, than the
                                      // max buy-sell rate will be today.
                dpl[i] = mpist;
            } else {
                dpl[i] = dpl[i - 1]; // otherwise, if today is earned less money than what it was yesterday, than let
                                     // yesterday remain the max buy-sell rate.
            }
        }

        // buy and sell from right towards left.
        // constraint -> It is mandatory to buy today, and sell at the max selling point
        // after today.
        // also calculate the max buy-sell point if it present at today or after today.

        int mpibt = 0;
        int maxat = arr[arr.length - 1];
        int[] dpr = new int[arr.length];

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > maxat) {
                maxat = arr[i];
            }
            mpibt = maxat - arr[i];
            if (mpibt > dpr[i + 1]) {
                dpr[i] = mpibt;
            } else {
                dpr[i] = dpr[i + 1];
            }
        }

        // calculating the overall profit from both buy-sell rate at each date.
        int op = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dpl[i] + dpr[i] > op) {
                op = dpl[i] + dpr[i];
            }
        }
        System.out.println(op);
    }

}