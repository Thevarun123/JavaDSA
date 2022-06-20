import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str){
           int n = str.length();
		  int len =  factorial(n);

		   for(int i=0; i<len;i++){
			   int temp =i;
			   StringBuilder sb = new StringBuilder(str);
			   for(int j =n; j>=1 ; j--){
				   int q = temp/j;
				   int rem = temp%j;
				   
				   System.out.print(sb.charAt(rem));
				   sb.deleteCharAt(rem);
				   temp =  q;
			   }
			     System.out.println();
		   }
	}
     public static int factorial(int n ){
		 int fact = 1;
		 for(int i=n; i>1;i--){
			 fact *= i;
           }
		   return fact;
	 }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}