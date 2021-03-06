package BasicDataStructure.BinaryTree;

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

    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null };
        // Integer a; vs int a; is that the int a only take the zero/int values but the
        // Integer a can take both the null as well as zero values. The Integer a
        // basically creates a reference in the stack to the variable in the main
        // memory.
        Node root = new Node(arr[0], null, null);

        Stack<Pair> st = new Stack<>();
        Pair rtp = new Pair(root, 1);

        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == 1) { // left push.
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++; // state will always get incremented if the coming value is null or any node.

            } else if (top.state == 2) { // right push.
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
        display(root);
    }
}
