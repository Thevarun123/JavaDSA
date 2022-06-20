import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) 
  {
    // write your code here 
    Scanner omega = new Scanner(System.in);
      int i = omega.nextInt();
      int count = 0;

      while(i!=0)
      {
        int rem = i % 10;
        count ++;
        int q = i/10;
        i=q; 
      }
      System.out.print(count);
  }
  }