import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int V;
    static ArrayList<ArrayList<Tuple>> adj;

    public Main(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
    }

    public static void add(int u, int v, int w) {
        adj.get(u).add(new Tuple(v, w));
        adj.get(v).add(new Tuple(u, w));
    }

    public static void shortestPath(int src, int W) {
        int[] dist = new int[V];
        Arrays.fill(dist, INF);

        ArrayList<Integer>[] B = new ArrayList[W * V + 1];
        for (int i = 0; i < W * V + 1; i++)
            B[i] = new ArrayList<>();

        B[0].add(src);
        dist[src] = 0;

        int idx = 0;
        while (true) {
            while (B[idx].size() == 0 && idx < W * V)
                idx++;

            if (idx == W * V)
                break;

            int u = B[idx].get(0);
            B[idx].remove(0);

            for (Tuple i : adj.get(u)) {
                int v = i.v;
                int weight = i.w;

                int du = dist[u];
                int dv = dist[v];

                if (dv > du + weight) {
                    dist[v] = du + weight;
                    dv = dist[v];
                    B[dv].add(0, v);
                }
            }
        }

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    static class Tuple {
        int v, w;

        Tuple(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); //no. of vertices
        Main g = new Main(V);
        int E = sc.nextInt(); //no. of edges
        for (int i = 0; i < E; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt(); //edges and weights
            int weight = sc.nextInt();
            add(src, dest, weight);
        }

        int sourceVertex = sc.nextInt(); //source vertex
        int maxWeight = sc.nextInt(); //min weight of an edge

        shortestPath(sourceVertex, maxWeight);
    }
}
