package AdjecencyMatrix;

import java.util.Scanner;

public class Graph {
    private int[][] adjMatrix;
    private int V;

    public Graph(int V) {
        this.V = V;
        adjMatrix = new int[V][V];
    }

    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }

    public void printGraph() {
        System.out.println("Adjacency Matrix Representation of the Graph:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices (V): ");
        int V = sc.nextInt();
        Graph graph = new Graph(V);
        System.out.print("Enter number of edges (E): ");
        int E = sc.nextInt();
        System.out.println("Enter the edges (u v) where u and v are vertices (0 to " + (V - 1) + "):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        graph.printGraph();

        sc.close();
    }
}


// ------------- sample input -------------
// Enter number of vertices (V): 4
// Enter number of edges (E): 4
// Enter the edges (u v) where u and v are vertices (0 to 3):
// 0 1
// 0 2
// 1 2
// 2 3


// ---------------output--------------
// Adjacency Matrix Representation of the Graph:
// 0 1 1 0 
// 1 0 1 0 
// 1 1 0 1 
// 0 0 1 0 

