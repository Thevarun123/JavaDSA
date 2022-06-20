import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<String> ans = getKPC(str);
        System.out.print(ans);
    }

    static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    // Declaring a global variable for the codes.
    public static ArrayList<String> getKPC(String str) {
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0); // pqrs //tu //vwx
        String ros = str.substring(1);// ros = rest of the string. 78// tu -> vwx //8 -> vwx // 0

        ArrayList<String> rres = getKPC(ros); // rres = "" (rres= recursion result)
        ArrayList<String> mres = new ArrayList<>();

        String codeforch = codes[ch - '0']; // 8 -> vwx //7 -> tu
        for (int i = 0; i < codeforch.length(); i++) {
            char chcode = codeforch.charAt(i);
            for (String rstr : rres) {
                mres.add(chcode + rstr);
            }
        }
        return mres;
    }

}