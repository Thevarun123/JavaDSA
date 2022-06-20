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
        int fee = scn.nextInt();

        int obsp = -arr[0]; // old brought state price
        int ossp = 0; // old sold state price

        for (int i = 1; i < arr.length; i++) {
            int nbsp = 0; // new buy state price
            int nssp = 0; // new sold state price

            // bsp
            if (ossp - arr[i] > obsp) {
                nbsp = ossp - arr[i];
            } else {
                nbsp = obsp;
            }

            // ssp
            if (obsp + arr[i] - fee > ossp) {
                nssp = obsp + arr[i] - fee;
            } else {
                nssp = ossp;
            }

            obsp = nbsp;
            ossp = nssp;
        }
        System.out.println(ossp);
    }

}