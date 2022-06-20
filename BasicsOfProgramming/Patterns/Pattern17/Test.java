import java.util.*;

public class Test {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int space = n / 2;
        int star = 1;

        for (int i = 1; i <= n; i++) {

            // space
            for (int j = 1; j <= space; j++) {
                if (i == (space + 1)) { // if the i is at the middle row
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }

            // star
            for (int j = 1; j <= star; j++) {
                System.out.print("*\t");
            }

            if (i <= n / 2) { // first half(increasing star values)
                star++;
            } else {
                star--;
            }

            System.out.println();
        }

    }
}