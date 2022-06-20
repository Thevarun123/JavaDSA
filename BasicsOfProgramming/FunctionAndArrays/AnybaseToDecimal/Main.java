import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // Number
        int b = scn.nextInt(); // Source Base
        int d = getValueIndecimal(n, b);
        System.out.println(d);
    }

    public static int getValueIndecimal(int n, int b) {
        // write your code here
        int ans = 0;
        int reg = 0;
        while (n > 0) {
            int power = (int) Math.pow(b, reg);
            int d1 = n % 10;
            n /= 10;
            ans += power * d1;
            // power *= b;
            reg++;
        }
        return ans;

    }
}