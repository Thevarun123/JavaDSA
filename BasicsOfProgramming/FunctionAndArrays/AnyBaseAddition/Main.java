import java.util.*;
// import java.lang.math;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getSum(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getSum(int b, int n1, int n2){
       // write ur code here
          int ans =0;
        //   int power = 1; //10^0;
          int a =0;  
          int carry =0;
           
           while(n1>0 ||n2>0 || carry>0 ){
          int power = (int)Math.pow(10,a); //10^0;
              int r1= n1%10;
              int r2= n2%10;
              n1= n1/10;
              n2= n2/10;

              int d = r1 + r2 + carry;
              carry= d / b;
              d = d % b;

               ans = ans + (power * d);
            //    power *= 10;
                 a++;
           }
               return ans;
   }
  }