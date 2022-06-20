import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')') { // Handling if there comes any closing bracket.
                boolean val = HandleClosing(st, '(');
                if (val == false) {
                    System.out.println(val);
                    return;
                }
            } else if (ch == '}') {
                boolean val = HandleClosing(st, '{');
                if (val == false) {
                    System.out.println(val);
                    return;
                }
            } else if (ch == ']') {
                boolean val = HandleClosing(st, '[');
                if (val == false) {
                    System.out.println(val);
                    return;
                }
            } else {

            }
        }
        if (st.size() == 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static boolean HandleClosing(Stack<Character> st, char corresoch) {
        if (st.size() == 0) { // This is the first condition that checks whether the stack is zero or not
                              // if the stack size comes zero that means that, all the elemetns have been
                              // popped out
                              // and we are checking the closing bracket against nothing in the stack.
                              // but if the stack size is something than we will look for other
                              // conditions...!!!
            return false;
        } else if (st.peek() != corresoch) { // This is the second condition that checks for the value that is not
                                             // equals to
                                             // corresponding opening bracket of the closing bracket.
            return false;
        } else {
            st.pop(); // This is the last condition that will get executed if the above mentioned
                      // conditions have been came out to be false.
                      // that means that the element stack peek() contains the corresponding bracket
                      // and that bracket will get popped out of the stack,
                      // returning true, that will give access to other elememts(brackets) to get
                      // pushed or popped into the stack.
            return true;
        }
    }
}
