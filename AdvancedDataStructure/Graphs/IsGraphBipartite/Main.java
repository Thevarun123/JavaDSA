import java.util.*;
import java.io.*;

public class Main {
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

    static class Pair {
        int v;
        String psf;
        int level;

        Pair(int v, String psf, int level) {

            this.v = v;
            this.psf = psf;
            this.level = level;

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

        // write your code here
        // theComponentCode
        int[] visited = new int[vtces];
        Arrays.fill(visited, -1);
        boolean flag = true;
        for (int i = 0; i < vtces; i++) {
            if (visited[i] == -1) { // unvisited

                boolean IsGraphBipartite = checkGraphBipartiteness(graph, i, visited);
                flag &= IsGraphBipartite;
                /*
                 * The difference between the logical operators (& and |) compared to their
                 * conditional counterparts (&& and ||) is that the former do not
                 * "shortcircuit"; the latter do. That is:
                 * 
                 * & and | always evaluate both operands
                 * && and || evaluate the right operand conditionally; the right operand is
                 * evaluated only if its value could affect the result of the binary operation.
                 * That means that the right operand is NOT evaluated when:
                 * The left operand of && evaluates to false
                 * (because no matter what the right operand evaluates to, the entire expression
                 * is false)
                 * The left operand of || evaluates to true
                 * (because no matter what the right operand evaluates to, the entire expression
                 * is true)
                 * So going back to your original question, yes, that construct is valid, and
                 * while |= is not exactly an equivalent shortcut for = and ||, it does compute
                 * what you want. Since the right hand side of the |= operator in your usage is
                 * a simple integer comparison operation, the fact that | does not shortcircuit
                 * is insignificant.
                 * 
                 * There are cases, when shortcircuiting is desired, or even required, but your
                 * scenario is not one of them.
                 * 
                 * It is unfortunate that unlike some other languages, Java does not have &&=
                 * and ||=.
                 */

            }
        }
        System.out.println(flag);
    }

    public static boolean checkGraphBipartiteness(ArrayList<Edge>[] graph, int src, int[] visited) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, src + "", 0));

        while (q.size() > 0) {
            // r m* w a*
            Pair rem = q.remove();

            if (visited[rem.v] > -1) { // already visited, also check for > -1
                // now check if it even or odd
                // if it is not even, then it is odd
                if (rem.level != visited[rem.v]) { // checking if the coming level is not equal to previous level, if
                                                   // found not equals then it is odd and simply return false, if found
                                                   // even then it is bipartite, and don't run the condition anymore.
                    // odd
                    return false;
                }
            } else {
                visited[rem.v] = rem.level;
            }

            for (Edge e : graph[rem.v]) {
                if (visited[e.nbr] == -1) { // unvisited
                    q.add(new Pair(e.nbr, rem.psf + e.nbr, rem.level + 1));
                }
            }
        }
        return true;
    }
}
