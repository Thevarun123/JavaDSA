import java.util.*;
import java.io.*;

// Theory 
// PriorityQueue is also known as heap sort as sorting can also be achieved by using the priority queue, its time complexity is n log(n). 
// The by default priority in priority queue is given to smaller elements, and if by any chance we have to give priority to bigger elements, then 
// we have to use Collections.reverseOrder(), in the parenthesis of the priority queue constructor.
// The time complexities of its functions is as follows:
// add() -> log(n)
// remove() -> log(n)
// peek() -> o(1)

public class first {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] ranks = { 12, 24, 45, 67, 89, 99, 2, 11 };

        for (int val : ranks) {
            pq.add(val);
        }

        while (pq.size() > 0) {
            System.out.println(pq.peek());
            pq.remove();
        }

    }
}
