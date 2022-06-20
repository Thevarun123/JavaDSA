import java.util.*;
import java.io.*;

public class Main {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        int th = Math.max(lh, rh) + 1;
        return th;
    }

    public static int diameter1(Node node) {
        if (node == null) {
            return 0;
        }
        // this call will represent the left's side diameter.
        int ld = diameter1(node.left);

        // this call will represent the right's side diameter.
        int rd = diameter1(node.right);

        // this int will represent the diameter. (diameter = total distance between the
        // two farthest nodes.)
        int f = height(node.left) + height(node.right) + 2;

        int d = Math.max(f, Math.max(ld, rd));

        return d;
    }

    public static class DiaPair {
        int ht;
        int dia;

        // DiaPair(){} //default contructor.

        // DiaPair(int ht, int dia){

        // this.ht = ht;
        // this.dia = dia;

        // }
    }

    public static DiaPair diameter2(Node node) {
        if (node == null) {
            DiaPair bp = new DiaPair();
            bp.ht = -1;
            bp.dia = 0;

            return bp;
        }
        // will return the left's side dia and height as well.
        DiaPair ld = diameter2(node.left);

        // will return the right's side dia and height as well.
        DiaPair rd = diameter2(node.right);

        DiaPair p = new DiaPair();
        p.ht = Math.max(ld.ht, rd.ht) + 1;

        int fes = ld.ht + rd.ht + 2;

        p.dia = Math.max(fes, Math.max(ld.dia, rd.dia));

        return p;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);

        int diameter = 0;
        // diameter = diameter1(root);
        // System.out.println(diameter);

        DiaPair p = diameter2(root);
        System.out.println(p.dia);

    }
}
