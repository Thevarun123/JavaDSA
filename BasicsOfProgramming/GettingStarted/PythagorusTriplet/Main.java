import java.util.*;
import java.io.*;
  
  public class Main {
  
  	  public static void main(String[] args) {
  	  	 Scanner scn = new Scanner(System.in);
		 int a = scn.nextInt();
		 int b = scn.nextInt();
		 int c = scn.nextInt();

        int a2 = a * a;
        int b2 = b * b;
        int c2 = c * c;

		if(a2 + b2 == c2){
			System.out.println(true);
		} else if(a2 + c2 == b2){
			System.out.println(true);
		} else if(b2 + c2 == a2){
			System.out.println(true);
		} else {
			System.out.println(false);
		}
		
		//  if((a * a) + (b * b) == (c* c)){
		// 	 System.out.println(true);
		//  } else if((a * a) + (c * c) == (a * a)){
		// 	 System.out.println(true);
		//  }else if((b * b) + (c * c) == (a * a)){
		// 	 System.out.println(true);
		//  } else {
		// 	 System.out.println(false);
		//  }
      
          
  	  }
  }