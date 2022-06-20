import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
      // write your code here  
      Scanner pen = new Scanner(System.in);
      int n = pen.nextInt();
      int temp =n;

      int count =0;
      while(temp>0)
      {
        int rem = temp%10;
        count ++;
        temp /= 10;
      }
      // System.out.print(count);
          int div = (int)(Math.pow(10,count-1));

          while(div!=0){
              int q = n / div;
               System.out.println(q);
               int rem = n % div;
               n = rem;
               div /= 10;
               
          }           
       }
    }