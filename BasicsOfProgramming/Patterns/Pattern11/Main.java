import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();

        int dis = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // System.out.print(dis + "\t");

                if (i == j || i != j) {
                    System.out.print(dis + "\t");
                } else {
                    System.out.print("\t");
                }
                dis++;
            }
            System.out.println();
        }
    }
}