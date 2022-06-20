import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner rat = new Scanner(System.in);
        int n = rat.nextInt();

        int inv = 0;
        int op = 1;
        int power = 1;
        while (n != 0) {
            int od = n % 10;
            n /= 10;
            int ip = od; // Inverted place becomes original digit.
            int id = op; // Inverted digite becomes original place.

            inv = inv + id * (int) Math.pow(10, ip - 1);
            power *= 10;
            op++;
        }
        System.out.println(inv);
    }
}