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

    // max code.
    public static int Max(Node node) {

        if (node.right != null) {

            return Max(node.right);

        } else {

            return node.data;

        }
    }

    public static Node remove(Node node, int data) {

        // baseCase.
        if (node == null) {
            return null;
        }

        // three cases we have to handle while solving it.
        // 1) O child -> then remove that leaf node and attach null to its parent.

        // 2) single child: (remove the node with a single child)
        // a) left child -> return the left child and attach it to its parent's left
        // side i.e node.left = remove(node.left, data).
        // b) right child -> return the right child and attach it to to parent's right
        // side i.e node.right = remove(node.right, data);

        // 3) two child:(node having two child):
        // step 1) Find the max: we will use the max function to find the max of its
        // left's side
        // step 2) Setting the node.data value as max: then we will replace the
        // node.data(that we have to remove) with the max of its left's side.
        // step 3) Remove the max: then we will remove the max from the left's side to
        // prevent duplicacy.

        // case 1
        if (data > node.data) {

            node.right = remove(node.right, data);

        } else if (data < node.data) {

            node.left = remove(node.left, data);

        } else {

            if (node.left != null && node.right != null) { // check if some value is in left and right.

                int lmax = Max(node.left); // find the max
                node.data = lmax; /* set the node.data value as max. */
                node.left = remove(node.left, lmax); /* remove the max. */
                return node;

            } else if (node.left != null) {

                return node.left;

            } else if (node.right != null) {

                return node.right;

            } else {
                // leaf node
                return null;
            }
        }
        return node;
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

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        root = remove(root, data);

        display(root);
    }

}
