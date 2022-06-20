import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner open = new Scanner(System.in);
        int n = open.nextInt();

        while (n != 0) {
            int rem = n % 10;
            System.out.println(rem);
            n /= 10;
        }
    }
}