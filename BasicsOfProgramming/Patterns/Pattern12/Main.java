import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();

        int a = 0;
        int b = 1;
        int c = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(c + "\t");
                a=b;
                b=c;
                c= a + b;  
                //    a = a + b;
                //    b=a;
            }
              
            System.out.println();
        }
    }
}