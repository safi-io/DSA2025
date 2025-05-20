package ElevenGraphs.Traversals;

import ElevenGraphs.Creation.UndirectedUnweightedGraphAdjacencyList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
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
}
