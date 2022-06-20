import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        HashMap<Character, Integer> hm = new HashMap<>();

        // finding the character of the string and doing two operations:
        // 1) Insertion: inserting the char in the hashMap with the freq 1 if that char
        // is not present in the hashMap.
        // 2) Updation: updating the frequency of the char if that char is already
        // present in the hashMap.

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (hm.containsKey(ch)) {

                int of = hm.get(ch);

                int nf = of + 1;

                hm.put(ch, nf);

            } else {

                hm.put(ch, 1);

            }

        }

        char mfc = str.charAt(0); /* assuming that the first character in the string has the highest frequency. */

        for (char key : hm.keySet()) {

            if (hm.get(key) > hm.get(mfc)) {

                mfc = key;

            }
        }

        System.out.println(mfc);

    }
}
