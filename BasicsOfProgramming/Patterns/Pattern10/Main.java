import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int osp = n / 2;
        int isp = -1;

        for (int i = 1; i <= n; i++) {
            // System.out.println(osp + "outer Space " + isp + "inner Space");
            // Outer space
            for (int j = 1; j <= osp; j++) {
                System.out.print("\t");
            }
            System.out.print("*\t");

            // Inner space
            for (int j = 1; j <= isp; j++) {
                System.out.print("\t");
            }
            if (i > 1 && i < n) {
                System.out.print("*");
            }
            if (i <= n / 2) {
                osp--;
                isp += 2;
            } else {
                osp++;
                isp -= 2;
            }
            System.out.println();
        }
    }
}