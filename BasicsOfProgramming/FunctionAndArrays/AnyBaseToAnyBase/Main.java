import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int destBase = scn.nextInt();

        int ans = AnyBasetoAnyBase(n, sourceBase, destBase);
        System.out.print(ans);

    }

    public static int AnyBasetoAnyBase(int n, int sourceBase, int destBase) {
        int deciNum = AnyBasetoDecimal(n, sourceBase); // call
        int ans = DecimaltoAnyBase(deciNum, destBase);
        return ans;
    }

    public static int AnyBasetoDecimal(int n, int b) { // Declaration.
        int ans = 0;
        int power = 1; // b ^ 0
        while (n > 0) {

            int rem = n % 10;
            ans = ans + (power * rem);
            n /= 10;
            power *= b;
        }
        return ans;
    }

    public static int DecimaltoAnyBase(int n, int b) { // Decalaration.
        int ans = 0;
        int power = 1; // 10^0;
        while (n > 0) {
            int rem = n % b;
            ans = ans + (power * rem);
            n /= b;
            power *= 10;
        }
        return ans;
    }
}