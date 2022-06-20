import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();

        // int tst = n + 1;
        // int tsp = 1;
        int st = n / 2 + 1;
        int sp = 1;
        // for(int t=1;t<=n;t++){
        // System.out.println(tst + "star" + tsp + " space");
        // if(t<tst-2){
        // tst = tst - 2;
        // tsp = tsp + 2;
        // }
        // else {
        // tst = tst + 2;
        // tsp = tsp - 2;
        // }
        // }
        for (int i = 1; i <= n; i++) {
            // System.out.println(st + "Star" + sp + "Space " + st + "star");
            // star
            for (int k = 1; k <= st; k++) {
                System.out.print("*\t");
            }
            // //space
            for (int j = 1; j <= sp; j++) {
                System.out.print("\t");
            }
            // //star
            for (int k = 1; k <= st; k++) {
                System.out.print("*\t");
            }
            System.out.println();

            if (i <= n / 2) {
                sp += 2;
                st--;
            } else {
                sp -= 2;
                st++;
            }
        }

    }
}