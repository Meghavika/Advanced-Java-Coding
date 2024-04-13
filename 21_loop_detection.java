import java.util.*;

class Main {

    static class Node {
        int data;
        Node next;
        int flag;
        Node(int x)
        {
            data = x;
            next = null;
              flag = 0;
        }
    };

    static Node push(Node head_ref, int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head_ref;
        head_ref = new_node;
        return head_ref;
    }

    static boolean detectLoop(Node h)
    {
        while (h != null) {
            if (h.flag == 1)
                return true;
            h.flag = 1;
            h = h.next;
        }
        return false;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        Node head = null;
        System.out.println("Enter the number of elements in the linked list:");
        int n = scanner.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            head = push(head, data);
        }
        
        System.out.println("Enter the index where you want to create the loop (-1 for no loop):");
        int loopIndex = scanner.nextInt();
        if (loopIndex != -1) {
            Node temp = head;
            for (int i = 0; i < loopIndex; i++) {
                temp = temp.next;
            }
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = temp;
        }

        if (detectLoop(head))
            System.out.print("Loop Found");
        else
            System.out.print("No Loop");
        
        scanner.close();
    }
}
