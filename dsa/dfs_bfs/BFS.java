import java.util.*;

public class BFS {
    private int V;
    private int[][] adjMatrix;

    public BFS(int V) {
        this.V = V;
        adjMatrix = new int[V][V];
    }

    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print((char) (node + 65) + " ");

            for (int i = 0; i < V; i++) {
                if (adjMatrix[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();
        BFS graph = new BFS(V);

        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        System.out.print("Enter the start vertex for BFS: ");
        int start = sc.nextInt();

        graph.bfs(start);
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
// Enter the start vertex for BFS: 0


// --------- output ----------
// BFS Traversal: A B C D E
