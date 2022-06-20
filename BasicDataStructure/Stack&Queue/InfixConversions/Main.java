import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<Character> ops = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                ops.push(ch);
            }

            // Condition if the ch is any operand.
            else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                prefix.push(ch + ""); // Converting char to string.
                postfix.push(ch + ""); // Converting char to string.
            }
            // Condition if the ch is any operator.
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // While loop for popping the stack content.
                while (ops.size() > 0 && ops.peek() != '(' && precedence(ch) <= precedence(ops.peek())) {
                    char optor = ops.pop();
                    // For Postfix.
                    String postv2 = postfix.pop();
                    String postv1 = postfix.pop();
                    String postopv = postv1 + postv2 + optor;
                    postfix.push(postopv);
                    // For Prefix.
                    String prev2 = prefix.pop();
                    String prev1 = prefix.pop();
                    String preopv = optor + prev1 + prev2;
                    prefix.push(preopv);

                }
                ops.push(ch);
            } else if (ch == ')') {

                // While loop for popping the stack content until opening bracket is not found.
                while (ops.peek() != '(') {
                    char optor = ops.pop();
                    // postfix
                    String postv2 = postfix.pop();
                    String postv1 = postfix.pop();
                    String postopv = postv1 + postv2 + optor;
                    postfix.push(postopv);
                    // For Prefix
                    String prev2 = prefix.pop();
                    String prev1 = prefix.pop();
                    String preopv = optor + prev1 + prev2;
                    prefix.push(preopv);

                }
                ops.pop();
            }
        }
        // Loop to empty the stack.
        while (ops.size() != 0) {
            char optor = ops.pop();
            // For Postfix
            String postv2 = postfix.pop();
            String postv1 = postfix.pop();
            String postopv = postv1 + postv2 + optor;
            postfix.push(postopv);
            // For Prefix
            String prev2 = prefix.pop();
            String prev1 = prefix.pop();
            String preopv = optor + prev1 + prev2;
            prefix.push(preopv);

        }
        // Printing the prefix as well as postfix.
        System.out.println(postfix.pop());
        System.out.println(prefix.pop());
    }

    public static int precedence(char ops) {
        if (ops == '+' || ops == '-') {
            return 1;
        } else if (ops == '*' || ops == '/') {
            return 2;
        } else {
            return 0; // We have to write this else down because compiler will take this as an
                      // assurance that when the input (ops) does not matches the above the
                      // conditions, at that
                      // condition it will print this else block.
        }
    }
}
