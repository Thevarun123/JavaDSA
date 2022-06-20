import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);

        // write ur code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int sp=n/2;
        int st=1;
        
        for(int i=1;i<=n;i++){
            // System.out.println(sp + "Space " + st + "Star");
                //space
             for(int j=1;j<=sp;j++){
                 System.out.print("\t");
             }
              //Star
             for(int k=1;k<=st;k++){
                 System.out.print("*\t");
             }
                 System.out.println();  
                
            if(i<=n/2){
                sp--;
                st= st + 2;
            }
             else{
                   sp++;
                   st = st -2;
             }
        }
     }
}