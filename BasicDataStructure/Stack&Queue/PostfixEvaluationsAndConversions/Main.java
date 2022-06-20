import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> vs = new Stack<>();
    Stack<String> is = new Stack<>();
    Stack<String> ps = new Stack<>();

     for(int i = 0; i < exp.length(); i++){
         char ch = exp.charAt(i);
         // Condition if the ch is any operator. 
         if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
             // Postfix Evaluation.
                int vsv2 = vs.pop();
                int vsv1 = vs.pop();
                int vsop = operation(vsv1, vsv2, ch);
                vs.push(vsop); 

             // Infix Conversion. 
                 String isv2  = is.pop(); 
                 String isv1  = is.pop();
                 String isans = "(" + isv1 + ch + isv2 + ")"; 
                 is.push(isans);

             // Prefix Conversion.
                String psv2  = ps.pop();
                String psv1  = ps.pop();
                String psans = ch + psv1 + psv2; 
                ps.push(psans);
         }
         // Condition if the ch is any operand. 
         else{
            vs.push(ch - '0'); // Conversion of ch value ascii code into desired value ascii and then they will get subtractes to obtain the integer no. Ex:   char       dec     
            is.push(ch + ""); // Conversion of char to int.                                                                                                                                                 //  2 - ASCII 50
            ps.push(ch + ""); // Conversion of char to int.                                                                                                                                                
                                                                                                                                                            //  0 - ASCII 48
                                                                                                                                                     //result   50 - 2 = 2 that 2 is of integer value and can be used for evaluation.          }
     }
     }
          System.out.println(vs.pop());
          System.out.println(is.pop());
          System.out.println(ps.pop());
}
      public static int operation(int v1, int v2, char ch){
          if(ch == '+'){
             return v1 + v2;

          } else if(ch == '-'){
              return v1 - v2;

          } else if(ch == '*'){
              return v1 * v2;

          } else {
              return v1 / v2;
          }
      }
}