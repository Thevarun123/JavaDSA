import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int t1d = scn.nextInt();
        int t2d = scn.nextInt();
        int t3d = scn.nextInt();
        toh(n, t1d, t2d, t3d);
    }

    public static void toh(int n, int t1id, int t2id, int t3id) {
        if (n == 0) {
            return;
        }
        toh(n - 1, t1id, t3id, t2id); // It will move the n - 1 disk to tower 3 from tower 1 using the help of tower
                                      // 2.
        System.out.println(n + "[" + t1id + " -> " + t2id + "]"); // Will print the n disk from tower 1 to tower 2.
        toh(n - 1, t3id, t2id, t1id); // Will move the n - 1 disk to tower 2 from tower 3 using the help of tower 1.
    }

}