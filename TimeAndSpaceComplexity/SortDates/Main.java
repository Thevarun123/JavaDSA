import java.io.*;
import java.util.*;

public class Main {

  public static void sortDates(String[] arr) {
    // write your code here
    countSort(arr,1000000, 100, 32); // Days
    countSort(arr,10000, 100, 13);  // Month
    countSort(arr,1, 10000, 2501); // Year
  }

  public static void countSort(String[] arr,int div, int mod, int range) {
    // write your code here
    int [] farr = new int[range];

   // loop for calculating the frequency. 
   for(int i = 0; i < arr.length; i++){
       farr[Integer.parseInt(arr[i], 10) / div % mod]++; // Applying the Integer.parseInt because the arr is in the form of String. 
       }

   // Loop for Prefix Sum Array. 
      for(int i = 1; i < farr.length; i++){
          farr[i] += farr[i - 1];
      }

   // Loop for getting the ans array.(Stable Sorting).  
      String [] ans = new String [arr.length];

      for(int i = arr.length - 1; i >= 0; i--){
          int val = Integer.parseInt(arr[i],10) / div % mod; 
          int pos = farr[val];
          ans[pos - 1] = arr[i]; 
          farr[val]--;
          
      } 
      //Filling original array with the ans array. 
      for(int i = 0 ; i < arr.length; i++){
          arr[i] = ans[i];
      }
  }

  public static void print(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      String str = scn.next();
      arr[i] = str;
    }
    sortDates(arr);
    print(arr);
  }

}