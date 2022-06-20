import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
       int t = scn.nextInt();
       for(int i = 0; i<t; i++){
           int n = scn.nextInt(); 
           boolean flag = true;
           for(int div =2; div*div <= n; div++){
               if(n%div == 0){
                   flag = false;
               }
           }
           if(flag == true){
               System.out.println("prime");
           }
           else {
               System.out.println("not prime");
           }
       }
        
       
  
   }
  }