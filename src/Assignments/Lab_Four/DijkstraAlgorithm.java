package Assignments.Lab_Four;

import java.util.*;

public class DijkstraAlgorithm {
    public static void dijkstra(ArrayList<Edge>[] graph, char src, HashMap<Character, Integer> charToIndex) {

        int numNodes = graph.length;
        int[] distances = new int[numNodes];
        boolean[] visited = new boolean[numNodes];
        char[] parent = new char[numNodes];

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(parent, '-');

        distances[charToIndex.get(src)] = 0;
        parent[charToIndex.get(src)] = src;

        PriorityQueue<NodeDistPair> pq = new PriorityQueue<>();
        pq.add(new NodeDistPair(src, 0));

        while (!pq.isEmpty()) {
            NodeDistPair currPair = pq.remove();
            Character currNode = currPair.Node;
            int currIndex = charToIndex.get(currNode);

            if (!visited[currIndex]) {
                visited[currIndex] = true;

                for (Edge edge : graph[currIndex]) {
                    Character neighbour = edge.dest;
                    int neighbourIndex = charToIndex.get(neighbour);
                    int weight = edge.wt;

                    // Relaxation
                    if (distances[currIndex] + weight < distances[neighbourIndex]) {
                        distances[neighbourIndex] = distances[currIndex] + weight;

                        parent[neighbourIndex] = edge.src;
                        pq.add(new NodeDistPair(neighbour, distances[neighbourIndex]));
                    }
                }
            }
        }

        printAllShortestPaths(distances, parent, src, charToIndex);


    }

    static void printAllShortestPaths(int[] dist, char[] parent, char src, HashMap<Character, Integer> charToIndex) {

        for (char dest : charToIndex.keySet()) {
            System.out.print("Node " + dest + " | dist = " + dist[charToIndex.get(dest)] + " | Path: ");
            printPath(parent, dest, src, charToIndex);
            System.out.println();
        }

    }

    public static void printPath(char[] parent, char dest, char src, HashMap<Character, Integer> charToIndex) {
        if (dest == src) {
            System.out.print(src);
            return;
        }

        printPath(parent, parent[charToIndex.get(dest)], src, charToIndex);
        System.out.print(" -> " + dest);
    }

    static class NodeDistPair implements Comparable<NodeDistPair> {
        public Character Node;
        public int distance;

        public NodeDistPair(Character node, int distance) {
            Node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(NodeDistPair other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

}
