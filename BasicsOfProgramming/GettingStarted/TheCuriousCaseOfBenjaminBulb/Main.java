import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // loop to print the perfect squares onto n and till n
        for (int i = 1; i * i < n; i++) {
            System.out.println(i * i);
        }
    }
}