package Algorithm;


import java.util.*;

public class PrimMST {
    // Prim's algorithm to find MST
    public static void primMST(int V, List<List<int[]>> adj) {
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2])); // Min-heap based on weight
        // Start from the first vertex (vertex 0)
        pq.add(new int[] { -1, 0, 0 }); // {vertex, weight}

        int mstWeight = 0;
        List<String> mstEdges = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();

            int from = edge[0];
            int u = edge[1];
            int weight = edge[2];

            // If this vertex has already been visited, skip it
            if (visited[u])
                continue;

            visited[u] = true;
            mstWeight += weight;

            if (from != -1) {
                mstEdges.add((char) (from + 65) + " - " + (char) (u + 65) + " with weight " + weight);
            }

            // Add all the neighbors to the priority queue
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];
                if (!visited[v]) {
                    pq.add(new int[] { u, v, w });
                }
            }
        }

        // Print the MST
        System.out.println("Edges in MST:");
        for (String edge : mstEdges) {
            System.out.println(edge);
        }
        System.out.println("Total weight of MST: " + mstWeight);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices (V): ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges (E): ");
        int E = sc.nextInt();
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        System.out.println("Enter edges (u v weight):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            adj.get(u).add(new int[] { v, weight });
            adj.get(v).add(new int[] { u, weight });
        }
        // Run Prim's algorithm
        primMST(V, adj);
        sc.close();
    }
}


// sample execution
// int V = sc.nextInt(); // 4
// int E = sc.nextInt(); // 5

// edges = [
//   (0,1,10),
//   (0,2,6),
//   (0,3,5),
//   (1,3,15),
//   (2,3,4)
// ]

// Edges in MST:
// A - D with weight 5
// D - C with weight 4
// A - B with weight 10
// Total weight of MST: 19
