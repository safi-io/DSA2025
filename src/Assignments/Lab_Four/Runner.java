package Assignments.Lab_Four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        System.out.print("Enter the number of Buildings: ");
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[V];
        HashMap<Character, Integer> charToIndex = new HashMap<>();
        CreateGraph(graph, charToIndex);

        System.out.print("BFS SOURCE: ");
        char bfsSource = sc.next().charAt(0);
        System.out.println("BFS (" + bfsSource + ") :");
        BFSTraversal.BFS(graph, bfsSource, charToIndex);

        System.out.print("\nDFS SOURCE: ");
        char dfsSource = sc.next().charAt(0);
        System.out.println("DFS (" + dfsSource + ") :");
        DFSTraversal.DFS(graph, dfsSource, charToIndex);

        System.out.print("\nDIJKSTRA SOURCE: ");
        char dijkstraSource = sc.next().charAt(0);
        System.out.println("Shortest Distance & Path from Source (" + dijkstraSource + "):");
        DijkstraAlgorithm.dijkstra(graph, dijkstraSource, charToIndex);

    }

    public static void CreateGraph(ArrayList<Edge>[] graph, HashMap<Character, Integer> charToIndex) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        Scanner sc = new Scanner(System.in);

        // 1. Assign labels for buildings (nodes)
        System.out.println("Enter labels for " + graph.length + " buildings (single characters):");
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Label for building " + (i + 1) + ": ");
            char label = sc.next().trim().charAt(0);
            charToIndex.put(label, i);
            graph[i] = new ArrayList<>();
        }

        // 2. Read pathways (edges)
        System.out.print("How many pathways (edges)? ");
        int E = sc.nextInt();
        System.out.println("Enter each pathway as: <src> <dest> <distance>");

        for (int i = 0; i < E; i++) {
            char u = sc.next().trim().charAt(0);
            char v = sc.next().trim().charAt(0);
            int w = sc.nextInt();

            int ui = charToIndex.get(u);
            int vi = charToIndex.get(v);

            // bidirectional edges
            graph[ui].add(new Edge(u, v, w));
            graph[vi].add(new Edge(v, u, w));
        }


    }
}
