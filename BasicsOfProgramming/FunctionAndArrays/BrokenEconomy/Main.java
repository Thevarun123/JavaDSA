import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
     Scanner take = new Scanner(System.in);
     int n = take.nextInt();
     int [] box = new int[n];
     // Inputting the values.
     for(int i = 0;i<box.length;i++){
        box[i] = take.nextInt();
     } 
     
     int d = take.nextInt();
     int lo =0, hi = box.length-1;
     int ceil =-1 , floor =-1;
     while(lo<=hi){
         int mid = (lo + hi ) / 2;
         if (d < box[mid]){
             hi = mid -1;
             ceil = box[mid];
         }
         else if(d > box[mid]){
             lo = mid + 1;
             floor = box[mid];
         }
         else{   // true
             ceil = box[mid];
             floor = box[mid];
             break;
         }
     }
         System.out.println(ceil + "\n" + floor);
        //  System.out.print(floor);

 }

}