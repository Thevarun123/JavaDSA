import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nsp = n / 2;
        int nst = 1;

        // Running the for loop for 1st part.
        for (int i = 1; i <= n; i++) {
            // Writing the loop to print the spaces.
            for (int j = 1; j <= nsp; j++) {
                // System.out.print(nsp + "Space"+ nst + "Star");
                if (i == (n / 2 + 1)) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }

            // stars.
            for(int j = 1; j<=nst; j++){
                System.out.print("*\t");
            }
               
                if(i<=n/2){
                    nst++;
                }
                else {
                    nst--;
                }

            
           System.out.println(); 
        }

    }
}