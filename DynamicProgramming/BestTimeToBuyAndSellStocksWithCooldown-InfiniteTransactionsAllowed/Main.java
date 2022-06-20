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

        int obsp = -arr[0];
        int ossp = 0;
        int ocsp = 0;

        for (int i = 1; i < arr.length; i++) {
            int nbsp = 0;
            int nssp = 0;
            int ncsp = 0;

            // nbsp (in this the nbsp will be calculated bases upon the ocsp)
            if (ocsp - arr[i] > obsp) {
                nbsp = ocsp - arr[i];
            } else {
                nbsp = obsp;
            }

            // nssp
            if (obsp + arr[i] > ossp) {
                nssp = obsp + arr[i];
            } else {
                nssp = ossp;
            }

            // ncsp
            if (ossp > ocsp) {
                ncsp = ossp;
            } else {
                ncsp = ocsp;
            }

            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }
        System.out.println(ossp);
    }

}