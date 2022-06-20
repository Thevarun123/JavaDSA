import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (visited[i][j] != true && arr[i][j] == 0) {
                    drawTree(arr, i, j, visited);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void drawTree(int[][] arr, int i, int j, boolean[][] visited) {
        // baseCase -> Smart
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] != 0 || visited[i][j] == true) {
            return;
        }
        visited[i][j] = true;

        drawTree(arr, i - 1, j, visited);
        drawTree(arr, i, j - 1, visited);
        drawTree(arr, i + 1, j, visited);
        drawTree(arr, i, j + 1, visited);
    }
}
