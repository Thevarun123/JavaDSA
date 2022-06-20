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

    public static class BSTPair {

        boolean IsBST;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        Node root;
        int size;

    }

    public static BSTPair IsBST(Node node) {
        // Base case.
        if (node == null) {

            BSTPair bp = new BSTPair();
            bp.IsBST = true;
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.root = node;
            bp.size = 0;

            return bp;

        }

        BSTPair lp = IsBST(node.left);
        BSTPair rp = IsBST(node.right);

        BSTPair mp = new BSTPair();

        mp.IsBST = lp.IsBST && rp.IsBST && // condition for trerBST.
                (node.data >= lp.max && node.data <= rp.min); // condition for nodeBST.

        mp.min = Math.min(node.data, lp.min); // In this submission I have removes the comparison of the rigth node's
                                              // min, because it there was no need to aaply it.
                                              // as our code can only compare the values of left node's min and
                                              // node.data, they both are sufficient for the comparison.
                                              // reason: BST rules states the reason appropriately as the left side is
                                              // always less than the right side. The same applies for every node that
                                              // represents tree itself.

        mp.max = Math.max(node.data, rp.max); // In this submission I have removes the comparison of the left node's
                                              // min, because it there was no need to aaply it.
                                              // as our code can only compare the values of right node's max and
                                              // node.data, they both are sufficient for the comparison.
                                              // reason: BST rules states the reason appropriately as the right side is
                                              // always greater than the left side. The same applies for every node that
                                              // represents tree itself.

        if (mp.IsBST) {

            mp.root = node;
            mp.size = lp.size + rp.size + 1;

        } else if (lp.size > rp.size) {

            mp.root = lp.root;
            mp.size = lp.size;

        } else {

            mp.root = rp.root;
            mp.size = rp.size;

        }
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

        BSTPair sol = IsBST(root);
        System.out.println(sol.root.data + "@" + sol.size);
    }
}
