import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);
    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it''s index (not position), if there is not
        // then print "none"
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }
        // Extracting the two values.
        while (st.size() > 1) {
            int i = st.pop();
            int j = st.pop();

            // Comparing the two values.
            if (arr[i][j] == 1) {

                // This states the i knows j -> i is not a celebrity.
                // We will push the celebrity into the stack.

                st.push(j);

            } else {

                // This states that i doesn't know j -> j is not a celebrity.
                // We will push the celebrity.

                st.push(i);

            }
        }
        int ptc = st.pop(); // To take out the last element remaining in the stack.
        // and assuming it might be celebrity. 1
        for (int i = 0; i < arr.length; i++) {
            if (i != ptc) {
                if (arr[i][ptc] == 0 && arr[ptc][i] == 1) {
                    // This means i doesn't know ptc && ptc knows i.
                    // Analogy -> Ramesh doesn't knows Shah Rukh Khan && Shah Rukh khan knows who is
                    // Ramesh.
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(ptc);
    }
}
