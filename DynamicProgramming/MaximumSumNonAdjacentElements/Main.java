import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int oinc = arr[0];
        int oexc = 0;

        for (int i = 1; i < arr.length; i++) {
            int ninc = arr[i] + oexc; // The inclusion is always added to the exclusion.
            int nexc = Math.max(oinc, oexc); // There's a comparison run between the old_inclusion and the old_exlusion,
                                             // whosever is found maximum is assigned as the new_exclusion. It is done
                                             // because
                                             // the we are required to get the maximum sum non adjacent element, so to
                                             // get it, it is our compulsion to take the greater element among the two,
                                             // so that, the greater the element, the maximum the sum will be in our
                                             // inclusion,

            oinc = ninc;
            oexc = nexc;
        }
        System.out.println(Math.max(oinc, oexc));
        // System.out.println(oinc);
    }
}
