import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for (int i = 0; i < n; i++) { // rows
            int icj = 1;
            for (int j = 0; j <= i; j++) { // columns
                System.out.print(icj + "\t");
                int icpj = icj * (i - j) / (j + 1);
                icj = icpj;
            }
            System.out.println(); // enter
        }

    }
}