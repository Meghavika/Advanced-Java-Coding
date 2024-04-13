import java.io.*;
import java.util.*;

class Main {
    private int V;
    private LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked")
    Main(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); //no. of vertices
        Main g = new Main(V);
        int E = sc.nextInt(); //no. of edges
        
        for (int i = 0; i < E; i++) {
            int src = sc.nextInt(); //edges
            int dest = sc.nextInt(); //weights
            g.addEdge(src, dest);
        }

        int startVertex = sc.nextInt(); //starting index of dfs

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex " + startVertex + ")");

        g.DFS(startVertex);
    }
}
