import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = factorial(n);// Invoke the function.
        System.out.println(ans);
    }

    public static int factorial(int n) {
        if (n == 0) {
            // return 0;
            return 1;
        }
        // int fnm1 = factorial(n-1);
        // int fn = n * fnm1;
        return n * factorial(n - 1);
    }

}