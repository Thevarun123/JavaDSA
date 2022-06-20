import java.util.*;
import java.io.*;

public class Main {
    public static class Edge {

        int v;
        int n;

        Edge(int v, int n) {

            this.v = v;
            this.n = n;

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // no of vertex
        int k = Integer.parseInt(br.readLine()); // no of edge

        // making the graph
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // inserting vertex in the graph
        for (int e = 0; e < k; e++) {
            String line = br.readLine();
            String[] parts = line.split(" ");

            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);

            graph[v1].add(new Edge(v1, v2)); // adding 1 -> 0 1
            graph[v2].add(new Edge(v2, v1)); // adding 1 -> 1 0
        }

        // get connected
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                ArrayList<Integer> comp = new ArrayList<>();
                drawTreeAndGenerate(graph, i, visited, comp);
                comps.add(comp);
            }
        }

        int total = 0;

        // loop on the components
        for (int i = 0; i < comps.size(); i++) {
            for (int j = i + 1; j < comps.size(); j++) {
                int size = comps.get(i).size() * comps.get(j).size();
                total += size;
            }
        }

        System.out.println(total);
    }

    public static void drawTreeAndGenerate(ArrayList<Edge>[] graph, int src, boolean[] visited,
            ArrayList<Integer> comp) {
        visited[src] = true;
        comp.add(src);

        for (Edge e : graph[src]) {
            if (visited[e.n] != true) {
                drawTreeAndGenerate(graph, e.n, visited, comp);
            }
        }
    }
}
