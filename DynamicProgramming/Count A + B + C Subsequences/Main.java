import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        int a = 0;
        int ab = 0;
        int abc = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                a = a + a + 1;
            }
            if (str.charAt(i) == 'b') {
                ab = ab + ab + a;
            }
            if (str.charAt(i) == 'c') {
                abc = abc + abc + ab;
            }
        }
        System.out.println(abc);
    }
}
