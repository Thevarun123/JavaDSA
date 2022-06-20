import java.util.*;
import java.io.*;

public class Hamiltonian {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());

        // write all your codes here
        HashSet<Integer> visited = new HashSet<Integer>();
        // HashSet extends AbstractSet and implements Set interface.
        // It creates a collections that uses hash table for storage.
        // A hash table stores the information by using a mechanism
        // called hashing. In hashing, the informational content of a
        // key is used to determine a unique value, called hashcode.

        printHamiltonianPathAndCycle(graph, src, visited, src + "", src);
    }

    public static void printHamiltonianPathAndCycle(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited,
            String psf, int osrc) {
        // masterBaseCase
        if (visited.size() == graph.length - 1) {

            // checking for the closingEdge
            boolean closingEdge = false;
            for (Edge e : graph[src]) {
                if (e.nbr == osrc) {
                    closingEdge = true;
                }
            }
            // printing * if hamiltoninan cycle or . if hamiltonian path.
            if (closingEdge) { // run it for 2nd iteration without iniatialization to true.
                System.out.println(psf + "*");
            } else {
                System.out.println(psf + ".");
            }

            return;
        }

        visited.add(src);
        for (Edge e : graph[src]) {
            if (visited.contains(e.nbr) != true) { // unvisited
                printHamiltonianPathAndCycle(graph, e.nbr, visited, psf + e.nbr, osrc);
            }
        }
        visited.remove(src);
    }
}
