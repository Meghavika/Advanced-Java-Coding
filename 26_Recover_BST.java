import java.util.*;

class Main {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node f, m, l, p;

        void correct(Node r) {
            if (r != null) {
                correct(r.left);

                if (p != null && r.data < p.data) {
                    if (f == null) {
                        f = p;
                        m = r;
                    } else
                        l = r;
                }

                p = r;
                correct(r.right);
            }
        }

        void correctBST(Node r) {
            f = m = l = p = null;
            correct(r);
            if (f != null && l != null) {
                int temp = f.data;
                f.data = l.data;
                l.data = temp;
            } else if (f != null && m != null) {
                int temp = f.data;
                f.data = m.data;
                m.data = temp;
            }
        }

        void printInorder(Node n) {
            if (n == null)
                return;
            printInorder(n.left);
            System.out.print(" " + n.data);
            printInorder(n.right);
        }

        Node ins(Node r, int d) {
            if (r == null) {
                return new Node(d);
            }
            if (d < r.data) {
                r.left = ins(r.left, d);
            } else if (d > r.data) {
                r.right = ins(r.right, d);
            }
            return r;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); //no. of nodes
        
        Node root = null;
        
        BinaryTree t = new BinaryTree();
        for (int i = 0; i < n; i++) {
            int v = s.nextInt();
            root = t.ins(root, v);
        }

        t.printInorder(root); //original tree
        t.correctBST(root);
        System.out.println("");
        t.printInorder(root); //fixed tree

        s.close();
    }
}
