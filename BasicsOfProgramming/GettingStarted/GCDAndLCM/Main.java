import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
      // write your code here  
        Scanner open = new Scanner(System.in);
        int n1 = open.nextInt();
        int n2 = open.nextInt();
        
        int tn1 = n1; //24
        int tn2 = n2; //36

        while(tn2 % tn1 > 0){

          int rem = tn2 % tn1;
          tn2 = tn1;
          tn1 = rem;
          }
          int gcd = tn1;
          System.out.println(gcd);

          int lcm = (n1*n2)/gcd; 
          System.out.println(lcm);
     } 
    }