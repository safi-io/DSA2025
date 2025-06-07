package ElevenGraphs.Algorithms;


import java.util.*;

public class PrimsAlgo {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

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

    static class NodeCostPair implements Comparable<NodeCostPair> {
        int node;
        int cost;
        int parent;

        public NodeCostPair(int node, int cost, int parent) {
            this.node = node;
            this.cost = cost;
            this.parent = parent;
        }

        public NodeCostPair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(NodeCostPair other) {
            return this.cost - other.cost;
        }
    }

    private static int primsCost(ArrayList<Edge>[] graph, int numVertices, int src) {
        PriorityQueue<NodeCostPair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[numVertices];
        int cost = 0;

        pq.add(new NodeCostPair(src, 0));

        while (!pq.isEmpty()) {
            NodeCostPair curr = pq.poll();
            if (!visited[curr.node]) {
                visited[curr.node] = true;
                cost += curr.cost;

                for (Edge edge : graph[curr.node]) {
                    pq.add(new NodeCostPair(edge.destination, edge.weight));
                }

            }

        }

        return cost;

    }

    private static void primsEdge(ArrayList<Edge>[] graph, int numVertices, int src) {
        PriorityQueue<NodeCostPair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[numVertices];
        ArrayList<Edge> minimumCostEdges = new ArrayList<>();


        pq.add(new NodeCostPair(src, 0, -1));

        while (!pq.isEmpty()) {
            NodeCostPair curr = pq.poll();
            if (!visited[curr.node]) {
                visited[curr.node] = true;

                if (curr.parent != -1) {
                    minimumCostEdges.add(new Edge(curr.parent, curr.node, curr.cost));
                }
                for (Edge edge : graph[curr.node]) {
                    pq.add(new NodeCostPair(edge.destination, edge.weight, curr.node));
                }

            }

        }

        for (Edge e : minimumCostEdges) {
            System.out.println(e.source + " " + e.destination + " " + e.weight);
        }
    }

    public static void main(String[] args) {
        int numVertices = 5;
        @SuppressWarnings("unchecked") ArrayList<Edge>[] graph = new ArrayList[numVertices];
        createGraph(graph);

//        int source = 0;
//        int minimumCost = primsCost(graph, numVertices, source);
//        System.out.println("Minimum Cost for Graph is: " + minimumCost);

        primsEdge(graph, numVertices, 0);
    }
}

