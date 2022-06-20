import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);

        // array1
        int a1 = scn.nextInt();

        int[] arr1 = new int[a1];

        for (int i = 0; i < arr1.length; i++) {

            arr1[i] = scn.nextInt();
        }

        // array2
        int a2 = scn.nextInt();

        int[] arr2 = new int[a2];

        for (int i = 0; i < arr2.length; i++) {

            arr2[i] = scn.nextInt();

        }

        // HashMap
        HashMap<Integer, Integer> fmap = new HashMap<>();

        for (int val : arr1) {

            if (fmap.containsKey(val)) {

                int of = fmap.get(val);
                int nf = of + 1;
                fmap.put(val, nf);

            } else {

                fmap.put(val, 1);

            }
        }

        // crosschecking with array2
        for (int val : arr2) {

            if (fmap.containsKey(val)) {

                if (fmap.get(val) > 0) {

                    System.out.println(val);
                    int of = fmap.get(val);
                    int nf = of - 1;
                    fmap.put(val, nf);

                }

                // when freq becomes 0, remove that key

            }
        }
    }
}
