import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
          Pair[] pairs = new Pair[arr.length]; // Making Pair array. 
          for(int i = 0; i < arr.length; i++){

             // assigning the value of first pair into the pair[i] value.  
               pairs[i] = new Pair( arr[i][0],arr[i][1] ); 
          }
            Arrays.sort(pairs);

           // Now, we need to tell java to sort the objects array, and clearly describe which object to consider as small and which to big. 
          // for doing this we will use Comparable<object_name>
         //  Ex. public static class Pair implements Comparable<Pair>{}
        //  to use this we will add a function into our class that is:
       //  public  int compareTo(Pair other)
             
             Stack<Pair> st = new Stack<>();
             for(int i = 0; i < pairs.length; i++){
                 if(i == 0){
           // If it the first pair then push it directly into the stack.           
                     st.push(pairs[i]); 

                 }  else {
           // If it is second pair then we will look for the top of the stack first and compare its respective start_time with the end_time of the top and 
          //  if the start_time is small then we will merge with the largest End_time among the two pairs as the new end_time,
        //    if the start_time is bigger then we will directly push it into the stack. 
                     Pair top = st.peek();
                    
                    if(pairs[i].st > top.et){
                        st.push(pairs[i]);
                    } else {
                        top.et = Math.max(top.et, pairs[i].et); // Jiska end_time bada hoega vo merge ho jaega aur ek naya pair ban jaega. 
                    }
                 }
             }
               Stack<Pair> rs = new Stack<>(); // Result stack to store the pairs. 
               while(st.size() > 0){
                   rs.push(st.pop()); // popping the merged times pair into the result stack so that the increasing order of start_time can be printed. 
               }
               while(rs.size() > 0){
                    Pair p = rs.pop(); 
                     System.out.println(p.st + " " + p.et);// printing the stack in the increasing order of start_time can be printed. 
               }
    }
      public static class Pair implements Comparable<Pair>{ // Making a class Pair to compare the values. 
          int st; // Start time.  
          int et; // End time. 

          Pair(int st, int et){
              this.st = st; 
              this.et = et; 
          }
          // this < other -> return -ve 
          // this = other -> return 0 
          // this < other -> return +ve 

          public  int compareTo(Pair other){
              if(this.st != other.st){ // If dono ka start_time barabar nahi hai to. 
                  return this.st - other.st;
              } else {
                 return this.et - other.et;
              }
          }
      }
}