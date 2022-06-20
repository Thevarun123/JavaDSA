import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);

        // array
        int n = scn.nextInt();

        int[] a1 = new int[n];

        for (int i = 0; i < a1.length; i++) {

            a1[i] = scn.nextInt();

        }

        HashMap<Integer, Boolean> hm = new HashMap<>();

        // 1st loop.
        for (int val : a1) {

            hm.put(val, true);

        }

        // 2nd loop.
        for (int val : a1) {

            if (hm.containsKey(val - 1)) {

                hm.put(val, false);

            }
        }

        // 3rd loop.
        int ml = 0;
        int msp = 0;
        for (int val : a1) {

            if (hm.get(val) == true) {

                int tl = 1;
                int tsp = val;

                while (hm.containsKey(tsp + tl)) {

                    tl++;

                }

                if (tl > ml) {

                    msp = tsp;
                    ml = tl;

                }
            }
        }
        for (int i = 0; i < ml; i++) {

            System.out.println(msp + i);

        }

    }

}
