package Final;
import java.util.Scanner;

public class Dijkstra {
    public static class Graph {

        public void addEdge(int vertex1, int vertex2, int weight) {
            try {
                int size;
                if (vertex1 >= 0 && vertex1 < size && vertex2 >= 0 && vertex2 < size) {
                    int[][] adjacencyMatrix;
                    adjacencyMatrix[vertex1][vertex2] = weight;
                    adjacencyMatrix[vertex2][vertex1] = weight;
                } else {
                    throw new IndexOutOfBoundsException("Invalid input");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }

        public void removeEdge(int vertex1, int vertex2) {
            try {
                if (vertex1 >= 0 && vertex1 < size && vertex2 >= 0 && vertex2 < size) {
                    int adjacencyMatrix;
                    adjacencyMatrix[vertex1][vertex2] = 0;
                    adjacencyMatrix[vertex2][vertex1] = 0;
                } else {
                    throw new IndexOutOfBoundsException("There are no values");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }

        public void findShortestPaths(int source) {
        }

        // ...
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
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
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
