import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     // write ur code here
       int n = scn.nextInt();
       int nsp= (n*2) - 3 ;
       int nst = 1;
       int val = 1;
        
        for(int i =1;i<=n;i++){
            // System.out.println(nst + " star " + nsp + " space " + nst + "Star");
             //star
             for(int j=1;j<=nst;j++){
                 System.out.print(val + "\t");
                 val++;
             }
            //     //space
                for(int j=1;j<=nsp;j++){
                  System.out.print("\t");
                }
                  if(i == n ){
                    nst--;
                    val --;
                  }
            //     //star
                    for(int j=1;j<=nst;j++){
                      val--;
                 System.out.print(val + "\t");
             }   
            
              nst++;
              nsp-=2;
             System.out.println();
             }
        }
 }