import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(toggle(str));
    }

    public static String toggle(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if (ch >= 'a' && ch < 'z') {
                char upc = (char) ('A' + ch - 'a');
                sb.setCharAt(i, upc);
            } else if (ch >= 'A' && ch < 'Z') {
                char lwc = (char) ('a' + ch - 'A');
                sb.setCharAt(i, lwc);
            }
        }
        String s1 = sb.toString();
        return s1;
    }
}