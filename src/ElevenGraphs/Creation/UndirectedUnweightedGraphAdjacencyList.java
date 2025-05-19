package ElevenGraphs.Creation;

import java.util.ArrayList;


public class UndirectedUnweightedGraphAdjacencyList {
    public static void main(String[] args) {
        int V = 4;

        @SuppressWarnings("unchecked") ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        // Print 2's Neighbours
        printNeighbours(graph, 2);

    }

    public static void printNeighbours(ArrayList<Edge>[] graph, int index) {
        for (int i = 0; i < graph[index].size(); i++) {
            System.out.println(i + 1 + " neighbour of " + index + " is: " + graph[index].get(i).dest);
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
}
