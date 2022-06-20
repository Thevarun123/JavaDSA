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

    static boolean IsBal = true;

    // Method - 1.
    public static int Bal(Node node) {

        // Base case.
        if (node == null) {
            return 0;
        }

        // call to left tree.
        int lb = Bal(node.left);

        // call to right tree.
        int rb = Bal(node.right);

        int bal = Math.abs(lb - rb);

        // condition if the val of bal comes greater than 1.
        if (bal > 1) {

            IsBal = false;

        }

        int ht = Math.max(lb, rb) + 1;

        return ht;
    }

    // Method 2.
    public static class BalPair {

        int ht;
        boolean IsBal;

    }

    public static BalPair Bal2(Node node) {
        if (node == null) {

            BalPair bp = new BalPair();
            bp.ht = 0; // here the height has been set to zero.

            bp.IsBal = true;
            return bp;

        }

        // call to left tree to check if it is balanced or not.
        BalPair lp = Bal2(node.left);

        // call to right tree to check if it is balanced or not.
        BalPair rp = Bal2(node.right);

        BalPair mp = new BalPair();
        mp.ht = Math.max(lp.ht, rp.ht) + 1;

        mp.IsBal = lp.IsBal && rp.IsBal &&
                (Math.abs(lp.ht - rp.ht) <= 1);

        return mp;
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
        BalPair bp = Bal2(root);
        System.out.println(bp.IsBal); // This time the call is from the pair class method i.e Method 2.
    }
}
