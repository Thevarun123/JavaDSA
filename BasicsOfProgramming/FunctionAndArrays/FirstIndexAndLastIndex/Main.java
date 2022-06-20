import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here.
        Scanner take = new Scanner(System.in);
        int n = take.nextInt();
        int[] box = new int[n];
        // Inputting the values.
        for (int i = 0; i < box.length; i++) {
            box[i] = take.nextInt();
        }
        int d = take.nextInt();
        int lo = 0;
        int hi = box.length - 1;
        int fi = -1; // FirstIndex.
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (d < box[mid]) {
                hi = mid - 1;
            } else if (d > box[mid]) {
                lo = mid + 1;
            } else {
                fi = mid;
                hi = mid - 1;
            }
        }
        System.out.println(fi);

        // int d = take.nextInt();
        lo = 0;
        hi = box.length - 1;
        int li = -1; // LastIndex.
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (d < box[mid]) {
                hi = mid - 1;
            } else if (d > box[mid]) {
                lo = mid + 1;
            } else {
                li = mid;
                lo = mid + 1;
            }
        }
        System.out.print(li);
    }
}