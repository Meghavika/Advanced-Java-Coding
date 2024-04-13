import java.util.*;

public class Main {
    static void calcSpan(int p[], int n, int S[]) {
        Deque<Integer> st = new ArrayDeque<Integer>();
        st.push(0);
        S[0] = 1;
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && p[st.peek()] <= p[i])
                st.pop();
            S[i] = (st.isEmpty()) ? (i + 1) : (i - st.peek());
            st.push(i);
        }
    }

    static void printArr(int arr[]) {
        System.out.print(Arrays.toString(arr));
    }

    // static void printArr(int arr[]) {
    //     for (int i = 0; i < arr.length; i++) {
    //         System.out.print(arr[i] + " ");
    //     }
    //     System.out.println();
    // }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int p[] = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = s.nextInt();
        }

        int S[] = new int[n];
        calcSpan(p, n, S);
        System.out.print("Spans: ");
        printArr(S);
        
        // System.out.print("Prices: ");
        // for (int i = 0; i < n; i++) {
        //     System.out.print(p[i] + " ");
        // }

        s.close();
    }
}
