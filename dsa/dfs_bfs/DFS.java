import java.util.*;

public class DFS {
    private int V;
    private int[][] adjMatrix;

    public DFS(int V) {
        this.V = V;
        adjMatrix = new int[V][V];
    }

    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[V];
        System.out.print("DFS Traversal: ");
        dfsUtil(start, visited);
        System.out.println();
    }

    private void dfsUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print((char) (node + 65) + " ");

        for (int i = 0; i < V; i++) {
            if (adjMatrix[node][i] == 1 && !visited[i]) {
                dfsUtil(i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();
        DFS graph = new DFS(V);

        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        System.out.print("Enter the start vertex for DFS: ");
        int start = sc.nextInt();

        graph.dfs(start);
        sc.close();
    }
}

// --------- sample input ------------
// Enter the number of vertices: 5
// Enter the number of edges: 6
// Enter the edges (u v):
// 0 1
// 0 2
// 1 3
// 1 4
// 2 4
// 3 4
// Enter the start vertex for DFS: 0

// --------- output ----------
// DFS Traversal: A B D E C
