import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int nsp = n / 2;
        int nst = 1;
        int val = 1;
        for (int i = 1; i <= n; i++) {
            // System.out.println(nsp + "Space " + num + "Number");
            // Space
            for (int j = 1; j <= nsp; j++) {
                System.out.print("\t");
            }
            int tempVal = val;
            // Star
            for (int j = 1; j <= nst; j++) {
                System.out.print(tempVal + "\t");
                if (j <= nst / 2) {
                    tempVal++;
                } else {
                    tempVal--;
                }

            }

            if (i <= n / 2) {
                nsp--;
                nst += 2;
                val++;
            } else {
                nsp++;
                nst -= 2;
                val--;
            }
            System.out.println();
        }
    }
}