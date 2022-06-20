import java.util.*;
   
   public class Main{
   
   public static void main(String[] args) {
     // write your code here 
     Scanner york = new Scanner(System.in);
     int n = york.nextInt();
     int k = york.nextInt();

      int temp = n;
      int count = 0;
      while(temp!=0){
        int rem = temp %10;
        count++;
        temp/= 10;
       }
        //  System.out.print(count); 
        k = k % count; 
        if(k<0)
        {
          k = k + count;
        }
        
      //  int div = (int)Math.pow(10, k);
      //  int mul= (int)Math.pow(10, count-k);

         int div = 1, mul =1;
         for(int i = 1; i<=count; i++){
             if(i<=k){
               div *= 10;
             }
             else {
               mul*= 10;
             }
         }
       int rem = n % div;
       int q = n /div; 
       int fun  = rem * mul;
       int ans = fun + q;
      
       System.out.print(ans);
    }
   }