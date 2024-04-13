import java.util.*;

public class Main {

    static class TopoSort {

        static void topoSortUtil(int v, List<List<Integer>> adj, boolean[] vis, Stack<Integer> stack)
        {
            vis[v] = true;
            for (int i : adj.get(v)) {
                if (!vis[i])
                    topoSortUtil(i, adj, vis, stack);
            }
            stack.push(v);
        }

        static void topoSort(List<List<Integer>> adj, int V)
        {
            Stack<Integer> stack = new Stack<>();
            boolean[] vis = new boolean[V];

            for (int i = 0; i < V; i++) {
                if (!vis[i])
                    topoSortUtil(i, adj, vis, stack);
            }

            System.out.print("Topological sorting of the graph: ");
            while (!stack.empty()) {
                System.out.print(stack.pop() + " ");
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int E = scanner.nextInt();

        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            edges.add(Arrays.asList(src, dest));
        }

        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> i : edges) {
            adj.get(i.get(0)).add(i.get(1));
        }

        TopoSort.topoSort(adj, V);

        scanner.close();
    }
}
