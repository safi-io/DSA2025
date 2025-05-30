package ElevenGraphs.Creation;

import ElevenGraphs.Traversals.Edge;

import java.util.ArrayList;

import static ElevenGraphs.Creation.PrintNeighboursUtil.printNeighbours;


public class UndirectedWeightedGraphAdjacencyList {
    public static void main(String[] args) {
        int V = 4;

        @SuppressWarnings("unchecked") ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        // Print 2's Neighbours
        printNeighbours(graph, 2);

    }

    private static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, -1));
    }

}
