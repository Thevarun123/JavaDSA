import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
 
    // write your code here
     Scanner take = new Scanner(System.in);
     int n = take.nextInt();
     int [] box = new int[n];
           
    // Inputting the values. 
    for(int i=0;i<box.length;i++){
        box[i]=take.nextInt();
    }
    int d = take.nextInt();
    int present = -1;
        //Checking against the value. 
     for(int i=0;i<box.length;i++){
         if(box[i]==d){
             System.out.print(i);
           return;
         }
     }
        System.out.println(present);
       }
 }