import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int fibn = FibMemoized(n, new int[n + 1]);
        System.out.println(fibn);
    }

    // thefibmemoized code
    public static int FibMemoized(int n, int[] qb) {
        // baseCase
        if (n == 0 || n == 1) {
            return n;
        }

        if (qb[n] > 0) {
            return qb[n];
        }

        int fibn1 = FibMemoized(n - 1, qb);
        int fibn2 = FibMemoized(n - 2, qb);
        int fibn = fibn1 + fibn2;

        qb[n] = fibn; // storing the fibonacci of n into the qb array. We have taken the n + 1, size
                      // because we are operating it from the index itself.
                      // which means the fibonacci of 2 will be stored in the index 2 respectively.
        return fibn;
    }
}
