import java.util.*;

class Main {

    static int knows(int a, int b, int[][] MATRIX) {
        return MATRIX[a][b];
    }

    static int findCelebrity(int n, int[][] MATRIX) {
        int[] indegree = new int[n];
        int[] outdegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = knows(i, j, MATRIX);
                outdegree[i] += x;
                indegree[j] += x;
            }
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Number of persons

        int[][] MATRIX = new int[n][n];
        System.out.println("Enter the adjacency matrix (1 for knowing, 0 for not knowing):");
        for (int i = 0; i < n; i++) { // Adjacency matrix
            for (int j = 0; j < n; j++) {
                MATRIX[i][j] = sc.nextInt();
            }
        }

        int id = findCelebrity(n, MATRIX);
        if (id == -1)
            System.out.print("No celebrity");
        else
            System.out.print("Celebrity ID " + id);

        sc.close();
    }
}
