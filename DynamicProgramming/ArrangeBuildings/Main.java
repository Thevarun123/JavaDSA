import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        long length = scn.nextInt();

        long oldBuilding = 1;
        long oldSpace = 1;

        for (int i = 2; i < length; i++) {
            // running it from 2 makes it more comprehensible. As running from two, it will
            // run (n-1) times.
            // for ex: for length = 6;, it will run five time, because for the zero'th value
            // it will make no building and space(genuine thing),
            // and for the 1st value we have already initialized the number of building and
            // space to be built across the roads.
            // So, running from 2 itself gives us a bried idea of from where the running of
            // the loop will actually take place. And certainly makes it more comprehensible
            // as well.

            long newBuilding = oldSpace;
            long newSpace = oldBuilding + oldSpace;

            oldBuilding = newBuilding;
            oldSpace = newSpace;
        }
        System.out.println((oldBuilding + oldSpace) * (oldBuilding + oldSpace));
    }
}
