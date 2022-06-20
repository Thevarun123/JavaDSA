import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner take= new Scanner(System.in);
    int r1= take.nextInt();
    int c1= take.nextInt();
    int [][] box1 = new int[r1][c1];
    //Inputting the values array1. 
    for(int i =0; i< box1.length; i++){
        for(int j =0; j<box1[0].length; j++){
            box1[i][j]= take.nextInt();
        }
    }

    int r2= take.nextInt();
    int c2= take.nextInt();
    int [][] box2 = new int[r2][c2];
    //Inputting the values of array2. 
    for(int i =0; i< box2.length; i++){
        for(int j =0; j<box2[0].length; j++){
            box2[i][j]= take.nextInt();
        }
    }
        // Checking that the multiplication can be possible or not. 
        if (c1!= r2){
            System.out.print("Invalid input");
            return;
        }
  
        //Creating the third loop to store the product. 
        int [][] prd = new int[r1][c2];
        for(int i =0; i< prd.length; i++){
        for(int j =0; j<prd[0].length;j++){
            for(int k=0;k<r2;k++){
            prd[i][j] += (box1[i][k] * box2[k][j]);
        }
    }
}

    //Printing the product loop. 
       for(int i =0; i< prd.length; i++){
        for(int j =0; j<prd[0].length; j++){
            System.out.print(prd[i][j] + " ");
 }
            System.out.println();
       

    }
 }
}