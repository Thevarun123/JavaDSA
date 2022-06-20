import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    int d = getProduct(b, n1, n2);
    System.out.println(d);
 }

 public static int getProduct(int b, int n1, int n2){
     // write your code here
        int ans=0;
        int power = 1;
        while(n2>0){
        int d1=n2%10;
        n2 /= 10;
        
        int prd= SingleDigitMultiplication(b, n1, d1);
        ans = getSum(b, ans , power*prd);
        power*=10;
        }
        return ans;
     
 }
   public static int SingleDigitMultiplication(int b, int n, int d1){
            int ans=0;
            int carry =0;
            int power =1;
            while(n>0 || carry > 0){
            int d2= n%10;
            n /= 10;
            int d = d1 * d2 + carry; 
            carry = d/b; 
            d= d%b; 
            ans += power * d;
            power*= 10;   
            }
            return ans;
   }
      public static int getSum(int b, int n1, int n2){
       // write ur code here
          int ans =0;
          int power = 1; //10^0;
          int carry =0;
           
           while(n1>0 ||n2>0 || carry>0 ){
               int rem1 = n1 % 10;
               int rem2 = n2 % 10;
               n1 /= 10;
               n2 /= 10;

               int sum = rem1 + rem2 + carry;
               carry = sum / b;
               int d = sum % b; 
               ans = ans + power * d;
               power *= 10;
           }
               return ans;
   }

}