import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
                int n = scn.nextInt();

             int nsp = 0; 
             int nst = n;   
        for(int i=1;i<=n;i++){
            
            //  System.out.println(nsp + "Space " + nst + "Star");
             
            // //  //space
             for(int j=1;j<=nsp;j++){
                 System.out.print("\t");
             }
            // //  //Star
             for(int k=1;k<=nst;k++){
                 System.out.print("*\t");
             }
                 System.out.println();
             nsp++;
             nst--;
    }
    }
}