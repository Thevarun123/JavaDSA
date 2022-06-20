import java.io.*;
import java.util.*;

public class Main{
    
     public static void main(String[] args) {
 Scanner take = new Scanner(System.in);
 int n = take.nextInt();
 int [] box = new int[n];

 //Inputting the values. 
 for(int i=0;i<box.length;i++){
     box[i]=take.nextInt();
 }
  //Creating the max and min terms. 
  int min = box[0];
  int max = box[0];

//Extracting the max and min terms among the values of array. 
  for(int i=0;i<box.length; i++){
      if(box[i]<min){
          min=box[i];  
      }
      else if(box[i]>max) {
          max= box[i];
      }
  }
 int span = max - min;
       System.out.println(span);
     }
  }