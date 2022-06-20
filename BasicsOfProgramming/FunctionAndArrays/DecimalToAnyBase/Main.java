import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // Number
        int b = scn.nextInt(); // Destination Base
        int dn = getValueInBase(n, b); // Passing the value to the function.
        System.out.println(dn); // Printing the value dn i.e assigned to the op given
                                // by the function itelf.
    }

    public static int getValueInBase(int n, int b) {
        // write code here
        int ans = 0;
        int power = 1;
        while (n > 0) {
            int d1 = n % b;
            n /= b;
            ans += power * d1;
            power *= 10;
        }
        return ans;

    }
}