import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    // write your code here
     Scanner take = new Scanner(System.in);
     int n = take.nextInt();
     int[] box = new int[n];
     
     //Inputting the elements of the array. 
     for(int i=0;i<box.length;i++){
          box[i]= take.nextInt();    
     }
         int max = box[0];
         //Finding the maximum digit. 
         for(int i=0;i<box.length;i++){
             if(box[i]>max){
                 max=box[i];
             }
         }
            // System.out.println(max);
            for(int i=max;i>=1;i--){
                for(int j=0;j<box.length;j++){
                    if(box[j]>=i){
                //Printing the stars if found the value of array at j index greater than                   i(7-> 6 -> 5 -> 4 -> 3 -> 2 -> 1)the value.  
                        System.out.print("*\t");
                    }
                        else {
                            System.out.print("\t");
                        }
                }
                    System.out.println();
            }
  }

}