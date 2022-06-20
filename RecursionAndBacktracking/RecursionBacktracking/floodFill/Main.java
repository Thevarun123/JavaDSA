import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        floodfill(arr, 0, 0, "", visited);
    }

    // asf -> answer so far
    public static void floodfill(int[][] maze, int sr, int sc, String asf, boolean[][] visited) {

        // baseCase1
        if (sr < 0 || sc < 0 || sr == maze.length || sc == maze[0].length || maze[sr][sc] == 1
                || visited[sr][sc] == true) {
            return;
        }

        // baseCase2
        if (sr == maze.length - 1 && sc == maze[0].length - 1) { // this condition represents that we have found our
                                                                 // element, now its time to return from that position
                                                                 // and explore other ways as well.
            System.out.println(asf);
            return;
        }

        // recursion calls: t->l->d->r. (anticlockwise)
        visited[sr][sc] = true;
        floodfill(maze, sr - 1, sc, asf + "t", visited); // t
        floodfill(maze, sr, sc - 1, asf + "l", visited); // l
        floodfill(maze, sr + 1, sc, asf + "d", visited); // d
        floodfill(maze, sr, sc + 1, asf + "r", visited); // r
        visited[sr][sc] = false;

    }

}