import java.util.*;

public class Main {
    static class Node {
        int key;
        Node left;
        Node right;

        Node(int data) {
            key = data;
            left = null;
            right = null;
        }
    }

    static void vertical(Node root, int hd, Map<Integer, List<Integer>> m) {
        if (root == null)
            return;

        List<Integer> v = m.get(hd);
        if (v == null) {
            v = new ArrayList<>();
            v.add(root.key);
            m.put(hd, v);
        } else
            v.add(root.key);

        vertical(root.left, hd - 1, m);
        vertical(root.right, hd + 1, m);
    }

    static void printVertical(Node root) {
        Map<Integer, List<Integer>> m = new TreeMap<>();
        int hd = 0;
        vertical(root, hd, m);

        for (List<Integer> list : m.values()) {
            StringBuilder sb = new StringBuilder();
            for (int val : list) {
                sb.append(val).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter values for the binary tree nodes (separated by spaces):");
        String[] inputValues = scanner.nextLine().split(" ");

        Node root = construct(inputValues);
        System.out.println("Vertical Order traversal is");
        printVertical(root);
    }

    static Node construct(String[] inputValues) {
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(Integer.parseInt(inputValues[0]));
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < inputValues.length) {
            Node t = q.poll();
            String l = inputValues[i++];
            if (!l.equals("null")) {
                t.left = new Node(Integer.parseInt(l));
                q.add(t.left);
            }
            if (i < inputValues.length) {
                String r = inputValues[i++];
                if (!r.equals("null")) {
                    t.right = new Node(Integer.parseInt(r));
                    q.add(t.right);
                }
            }
        }
        return root;
    }
}
