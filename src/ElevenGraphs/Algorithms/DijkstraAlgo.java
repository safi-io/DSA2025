package ElevenGraphs.Algorithms;

import java.util.*;

public class DijkstraAlgo {

    // Edge class representing a directed edge from 'source' to 'destination' with a 'weight'
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Graph construction using adjacency list
    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 4));
        graph[0].add(new Edge(0, 2, 8));

        graph[1].add(new Edge(1, 0, 4));
        graph[1].add(new Edge(1, 4, 6));

        graph[2].add(new Edge(2, 0, 8));
        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 2, 2));
        graph[3].add(new Edge(3, 4, 10));

        graph[4].add(new Edge(4, 1, 6));
        graph[4].add(new Edge(4, 3, 10));
    }

    // Pair class to store (node, distance) for the priority queue
    static class NodeDistPair implements Comparable<NodeDistPair> {
        int node;
        int distance;

        public NodeDistPair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(NodeDistPair other) {
            return Integer.compare(this.distance, other.distance); // min-heap
        }
    }

    public static int[] dijkstra(ArrayList<Edge>[] graph, int source) {
        int numNodes = graph.length;
        int[] distances = new int[numNodes];
        boolean[] visited = new boolean[numNodes];

        // Initialize all distances to infinity, except the source
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<NodeDistPair> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new NodeDistPair(source, 0));

        while (!priorityQueue.isEmpty()) {
            NodeDistPair current = priorityQueue.poll();
            int currNode = current.node;

            if (!visited[currNode]) {
                visited[currNode] = true;

                for (Edge edge : graph[currNode]) {
                    int neighbor = edge.destination;
                    int weight = edge.weight;

                    if (!visited[neighbor] && distances[currNode] + weight < distances[neighbor]) {

                        distances[neighbor] = distances[currNode] + weight;
                        priorityQueue.add(new NodeDistPair(neighbor, distances[neighbor]));
                    }

                }

            }
        }

        return distances;
    }

    public static void main(String[] args) {
        int numVertices = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[numVertices];
        createGraph(graph);

        int source = 0;
        int[] shortestDistances = dijkstra(graph, source);

        System.out.println("Shortest distances from node " + source + ":");
        for (int i = 0; i < shortestDistances.length; i++) {
            System.out.println("To node " + i + " = " + shortestDistances[i]);
        }
    }
}
