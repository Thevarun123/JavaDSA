import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack<Integer> vs = new Stack<>();
        Stack<String> is = new Stack<>();
        Stack<String> pts = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);

            // Condition to check if ch is any operator or not.
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                // Prefix Evaluation.
                int vsv1 = vs.pop();
                int vsv2 = vs.pop();
                int vsopv = operation(vsv1, vsv2, ch);
                vs.push(vsopv);

                // Infix Conversion.
                String isv1 = is.pop();
                String isv2 = is.pop();
                String isans = "(" + isv1 + ch + isv2 + ")";
                is.push(isans);

                // Postfix Conversion.
                String ptsv1 = pts.pop();
                String ptsv2 = pts.pop();
                String ptsans = ptsv1 + ptsv2 + ch;
                pts.push(ptsans);

            } else {
                vs.push(ch - '0'); // Conversion of ch value ascii code into desired value ascii and then they will
                                   // get subtractes to obtain the integer no. Ex: char dec
                is.push(ch + ""); // Conversion of char to int. // 2 - ASCII 50
                pts.push(ch + ""); // Conversion of char to int. //

            }
        }
        System.out.println(vs.pop());
        System.out.println(is.pop());
        System.out.println(pts.pop());
    }

    public static int operation(int v1, int v2, char ch) {
        if (ch == '+') {
            return v1 + v2;
        } else if (ch == '-') {
            return v1 - v2;
        } else if (ch == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }
}