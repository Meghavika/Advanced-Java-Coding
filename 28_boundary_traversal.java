import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    private void addLeftBound(Node root, ArrayList<Integer> ans) {
        root = root.left;
        while (root != null) {
            if (!isLeaf(root)) {
                ans.add(root.data);
            }
            root = root.left != null ? root.left : root.right;
        }
    }

    private void addRightBound(Node root, ArrayList<Integer> ans) {
        root = root.right;
        Stack<Integer> stk = new Stack<>();
        while (root != null) {
            if (!isLeaf(root)) {
                stk.push(root.data);
            }
            root = root.right != null ? root.right : root.left;
        }
        while (!stk.isEmpty()) {
            ans.add(stk.peek());
            stk.pop();
        }
    }

    private void addLeaves(Node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            ans.add(root.data);
            return;
        }
        addLeaves(root.left, ans);
        addLeaves(root.right, ans);
    }

    ArrayList<Integer> boundary(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (!isLeaf(root)) {
            ans.add(root.data);
        }
        addLeftBound(root, ans);
        addLeaves(root, ans);
        addRightBound(root, ans);
        return ans;
    }

    static Node constructTree(Scanner sc) {
        System.out.println("Enter the binary tree nodes in level order (separated by spaces), use 'null' for empty nodes:");
        String[] input = sc.nextLine().split(" ");
        if (input.length == 0 || input[0].equals("null")) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        Node root = new Node(Integer.parseInt(input[0]));
        q.add(root);

        for (int i = 1; i < input.length; i += 2) {
            Node curr = q.poll();
            if (!input[i].equals("null")) {
                curr.left = new Node(Integer.parseInt(input[i]));
                q.add(curr.left);
            }
            if (i + 1 < input.length && !input[i + 1].equals("null")) {
                curr.right = new Node(Integer.parseInt(input[i + 1]));
                q.add(curr.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main tree = new Main();
        Node root = constructTree(sc);

        ArrayList<Integer> ans = tree.boundary(root);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
