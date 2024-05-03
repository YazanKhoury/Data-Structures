package Final;
import java.util.Scanner;

public class Dijkstraa{
    public static class Graph {
        private int size;
        private int[][] adjacencyMatrix;

        public Graph(int size) {
            this.size = size;
            this.adjacencyMatrix = new int[size][size];
        }

        public void addEdge(int vertex1, int vertex2, int weight) {
            if (vertex1 >= 0 && vertex1 < size && vertex2 >= 0 && vertex2 < size) {
                adjacencyMatrix[vertex1][vertex2] = weight;
                adjacencyMatrix[vertex2][vertex1] = weight;
            } else {
                System.out.println("Invalid input");
            }
        }

        public void removeEdge(int vertex1, int vertex2) {
            if (vertex1 >= 0 && vertex1 < size && vertex2 >= 0 && vertex2 < size) {
                adjacencyMatrix[vertex1][vertex2] = 0;
                adjacencyMatrix[vertex2][vertex1] = 0;
            } else {
                System.out.println("There are no values");
            }
        }

        public void print() {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(adjacencyMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        public void findShortestPaths(int source) {
            // Array to store the shortest distance from source to each vertex
            int[] distance = new int[size];
            // Array to track visited vertices
            boolean[] visited = new boolean[size];
            // Initialize distance array with maximum values and visited array as false
            for (int i = 0; i < size; i++) {
                distance[i] = Integer.MAX_VALUE;
                visited[i] = false;
            }
            // Distance from source to itself is 0
            distance[source] = 0;

            for (int i = 0; i < size - 1; i++) {
                // Find the vertex with the minimum distance value
                int minDistanceVertex = findMinDistanceVertex(distance, visited);
                // Mark the vertex as visited
                visited[minDistanceVertex] = true;

                // Update the distance value of the adjacent vertices
                for (int j = 0; j < size; j++) {
                    if (!visited[j] && adjacencyMatrix[minDistanceVertex][j] != 0 &&
                            distance[minDistanceVertex] != Integer.MAX_VALUE &&
                            distance[minDistanceVertex] + adjacencyMatrix[minDistanceVertex][j] < distance[j]) {
                        distance[j] = distance[minDistanceVertex] + adjacencyMatrix[minDistanceVertex][j];
                    }
                }
            }

            // Print the shortest distances from source to all vertices
            System.out.println("Shortest distances from source " + source + ":");
            for (int i = 0; i < size; i++) {
                System.out.println("Vertex " + i + ": " + distance[i]);
            }
        }

        private int findMinDistanceVertex(int[] distance, boolean[] visited) {
            int minDistance = Integer.MAX_VALUE;
            int minDistanceVertex = -1;
            for (int i = 0; i < size; i++) {
                if (!visited[i] && distance[i] <= minDistance) {
                    minDistance = distance[i];
                    minDistanceVertex = i;
                }
            }
            return minDistanceVertex;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the graph: ");
        int size = scanner.nextInt();
        Graph graph = new Graph(size);

        System.out.println("Enter the edges (vertex1, vertex2, weight):");
        System.out.println("(Enter -1 to finish)");

        int vertex1, vertex2, weight;
        do {
            System.out.print("Vertex 1: ");
            vertex1 = scanner.nextInt();
            if (vertex1 == -1) break;

            System.out.print("Vertex 2: ");
            vertex2 = scanner.nextInt();
            if (vertex2 == -1) break;

            System.out.print("Weight: ");
            weight = scanner.nextInt();

            graph.addEdge(vertex1, vertex2, weight);
        } while (true);

        System.out.println("Adjacency Matrix:");
        graph.print();

        System.out.print("Enter the source vertex for finding shortest paths: ");
        int source = scanner.nextInt();
        graph.findShortestPaths(source);

        scanner.close();
    }
}
