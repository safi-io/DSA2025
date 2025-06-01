package ElevenGraphs.Algorithms;

import java.util.*;

public class BellmanFordAlgo {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(1, 4));
        graph[0].add(new Edge(2, 8));

        graph[1].add(new Edge(0, 4));
        graph[1].add(new Edge(4, 6));

        graph[2].add(new Edge(0, 8));
        graph[2].add(new Edge(3, 2));

        graph[3].add(new Edge(2, 2));
        graph[3].add(new Edge(4, -5));  // Negative weight edge here!

        graph[4].add(new Edge(1, 6));
        graph[4].add(new Edge(3, 10));

    }

    static int[] bellman(ArrayList<Edge>[] graph, int source, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int u = 0; u < V; u++) {
                for (Edge edge : graph[u]) {
                    int v = edge.destination;
                    int weight = edge.weight;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int numVertices = 5;
        @SuppressWarnings("unchecked") ArrayList<Edge>[] graph = new ArrayList[numVertices];
        createGraph(graph);

        int source = 0;
        int[] shortestDistances = bellman(graph, source, numVertices);

        System.out.println("Shortest distances(Negative Weights also) from node " + source + ":");
        for (int i = 0; i < shortestDistances.length; i++) {
            System.out.println("To node " + i + " = " + shortestDistances[i]);
        }
    }
}
