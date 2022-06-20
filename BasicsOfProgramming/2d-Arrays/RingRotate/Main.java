import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int s = scn.nextInt();
        int r = scn.nextInt();
        rotateShell(arr, s, r);
        display(arr);

    }

    public static void rotateShell(int[][] arr, int s, int r) {
        int[] Oned = FillOnedFromShell(arr, s);
        rotate(Oned, r);
        FillShellFromOned(arr, s, Oned);
    }

    public static int[] FillOnedFromShell(int[][] arr, int s) {
        int minr = s - 1;
        int minc = s - 1;
        int maxr = arr.length - s;
        int maxc = arr[0].length - s;
        int sz = 2 * (maxr - minr + maxc - minc);
        // 2 * (maxr-minr + 1)+ 2* (maxc - minc + 1) -4;
        // (maxr-minr+1) + bw + (maxr-minr+1) + tw -4
        // lw + bw + rw + tw-4; // -4 is done just to avoid the duplicacy of elements.
        int[] Oned = new int[sz];
        // lw
        int idx = 0;
        for (int i = minr, j = minc; i <= maxr; i++) {
            Oned[idx] = arr[i][j];
            idx++;
        }
        // bw
        for (int i = maxr, j = minc + 1; j <= maxc; j++) {
            Oned[idx] = arr[i][j];
            idx++;
        }
        // rw
        for (int i = maxr - 1, j = maxc; i >= minr; i--) {
            Oned[idx] = arr[i][j];
            idx++;
        }
        // tw
        for (int i = minr, j = maxc - 1; j >= minc + 1; j--) {
            Oned[idx] = arr[i][j];
            idx++;
        }
        return Oned;
    }

    public static void FillShellFromOned(int[][] arr, int s, int[] Oned) {
        int minr = s - 1;
        int minc = s - 1;
        int maxr = arr.length - s;
        int maxc = arr[0].length - s;
        int idx = 0;
        for (int i = minr, j = minc; i <= maxr; i++) {
            arr[i][j] = Oned[idx];
            idx++;
        }
        // bw
        for (int i = maxr, j = minc + 1; j <= maxc; j++) {
            arr[i][j] = Oned[idx];
            idx++;
        }
        // rw
        for (int i = maxr - 1, j = maxc; i >= minr; i--) {
            arr[i][j] = Oned[idx];
            idx++;
        }
        // tw
        for (int i = minr, j = maxc - 1; j >= minc + 1; j--) {
            arr[i][j] = Oned[idx];
            idx++;
        }

    }

    public static void rotate(int[] Oned, int r) {
        r = r % Oned.length;
        if (r < 0) {
            r += Oned.length; // Solving for negative values.
        }
        reverse(Oned, 0, Oned.length - 1 - r); // Part 1 reverse.
        reverse(Oned, Oned.length - r, Oned.length - 1);// Part 2 reverse.
        reverse(Oned, 0, Oned.length - 1);// Whole reverse.
    }

    public static void reverse(int Oned[], int li, int ri) {
        while (li < ri) {
            int temp = Oned[li];
            Oned[li] = Oned[ri];
            Oned[ri] = temp;

            li++;
            ri--;
        }
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}