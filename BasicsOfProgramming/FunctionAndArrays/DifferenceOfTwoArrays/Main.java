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
        int[] diff = new int[n2];

        int i = box1.length - 1;
        int j = box2.length - 1;
        int k = diff.length - 1;

        int carry = 0;
        while (k >= 0) {
            int d = box2[j] + carry;

            if (i >= 0) {
                d = d - box1[i];
            }
            if (d < 0) {
                d = d + 10;
                carry = -1;
            } else {
                carry = 0;
            }
            diff[k] = d;

            i--;
            j--;
            k--;
        }

        int index = 0;
        while (diff[index] == 0) {
            index++;
        }
        for (int idiff = index; idiff < diff.length; idiff++) {
            System.out.println(diff[idiff]);
        }
    }

}