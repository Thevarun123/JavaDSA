import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner take = new Scanner(System.in);
        int n1 = take.nextInt();
        int[] box1 = new int[n1];
        // Inputting the values.
        for (int i = 0; i < box1.length; i++) {
            box1[i] = take.nextInt();
        }
        int n2 = take.nextInt();
        int[] box2 = new int[n2];
        // Inputting the values.
        for (int i = 0; i < box2.length; i++) {
            box2[i] = take.nextInt();
        }
        int[] sum = new int[n1 > n2 ? n1 : n2];

        int i = box1.length - 1;
        int j = box2.length - 1;
        int s = sum.length - 1;

        int carry = 0;
        while (s >= 0) {
            int d = carry;

            if (i >= 0) {
                d += box1[i];
            }
            if (j >= 0) {
                d += box2[j];
            }
            carry = d / 10;
            d %= 10;

            sum[s] = d;
            i--;
            j--;
            s--;
        }
        if (carry > 0) {
            System.out.print(carry);
        }
        // Loop for printing the sumn array.
        for (int isum = 0; isum < sum.length; isum++) {
            System.out.println(sum[isum]);
        }

    }
}