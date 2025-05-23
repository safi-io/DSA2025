package ElevenGraphs.Creation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class UndirectedUnweightedGraphAdjacencyList { // O(V+E)
    public static void main(String[] args) {
        int V = 7;

        @SuppressWarnings("unchecked") ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        DFS(graph, 0);
    }

    public static void BFS(ArrayList<Edge>[] graph, int source) {

        // Add Immediate Neighbours


        Queue<Integer> qe = new LinkedList<>();
        qe.add(source);

        HashSet<Integer> visited = new HashSet<>(); // For Checking, If it's already in there!

        while (!qe.isEmpty()) {
            int current = qe.remove();

            if (!visited.contains(current)) {
                System.out.print(current + " ");
                visited.add(current);

                // Add all Neighbours of current edge into graph
                for (Edge e : graph[current]) {
                    qe.add(e.dest);
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge>[] graph, int source) { // O(V+E)
        // Keep Going on 1st Neighbour
        DFSHelper(graph, source, new HashSet<>());
    }

    private static void DFSHelper(ArrayList<Edge>[] graph, int current, HashSet<Integer> Visited) {
        if (Visited.contains(current)) {
            return;
        }

        System.out.print(current + " ");
        Visited.add(current);

        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            DFSHelper(graph, e.dest, Visited);
        }

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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));

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
