import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[n][m];

        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;

        // filling the first row of dp and calculating the least and sleast
        // simultaneously.
        for (int j = 0; j < arr[0].length; j++) {
            dp[0][j] = arr[0][j];

            // least and sleast
            if (arr[0][j] <= least) { // smaller than both
                sleast = least;
                least = arr[0][j];
            } else if (arr[0][j] <= sleast) { // only smaller than sleast. (means comes between least and sleast. For
                                              // ex: least = 12 and sleast 15, and the value comes to be 13, so only
                                              // sleast will get updated, with no effect on the least)
                sleast = arr[0][j];
            }
        }

        // finding the cost of the paint of the houses, using the rules:
        // 1) no two adjacent houses have the same paint.
        // -> abiding by this rule we first check that least is equal to
        // dp[house][paint], if it is then we add the actual cost of that paint to the
        // sleast,
        // otherwise, we just simply add least to the actual cost of that paint.

        for (int i = 1; i < dp.length; i++) {
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;

            for (int j = 0; j < dp[0].length; j++) {

                if (least == dp[i - 1][j]) { // if the least comes to be the adjacent of the dp[i-1][j] element, then we
                                             // simply add sleast to the actual cost of the element.
                    dp[i][j] = arr[i][j] + sleast;
                } else {
                    dp[i][j] = arr[i][j] + least; // if the least does not comes to be the adjacent of the dp[i-1][j]
                                                  // element, then we simply add least to the actual cost of the element
                }

                // calculating the nleast and the nsleast for the next row.
                if (dp[i][j] <= nleast) {
                    nsleast = nleast;
                    nleast = dp[i][j];
                } else if (dp[i][j] <= nsleast) {
                    nsleast = dp[i][j];
                }
            }
            least = nleast;
            sleast = nsleast;
        }
        System.out.println(least); // ans is the least, which is the minimun of the last row after traversing the
                                   // whole dp.
    }
}
