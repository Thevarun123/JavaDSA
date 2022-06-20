import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getDifference(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getDifference(int b, int n1, int n2){
       // write your code here
       int ans = 0;
       int power = 1; //10^0;
       int carry = 0;
       while(n2>0){
       int r1= n1%10;
       int r2= n2%10;
       n1 /= 10;
       n2 /= 10;
          
          r2= r2+ carry; 
          int d = r2-r1;
          if(d<0){
            d += b;
            carry=-1;
          }
          else{
            carry=0;
          } 

         ans += power*d;
         power*= 10;
   } 
       return ans; 
  
  }
}