import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int ozeroes = 1;
        int oones = 1;

        for (int i = 2; i <= n; i++) {
            int nzeroes = oones;
            int nones = ozeroes + oones;

            ozeroes = nzeroes;
            oones = nones;
        }
        System.out.println(ozeroes + oones);
    }
}
