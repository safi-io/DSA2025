package ElevenGraphs.Traversals;

import java.util.ArrayList;
import java.util.HashSet;

public class DFSTraversal {

    public static void DFS(ArrayList<Edge>[] graph, int source) { // O(V+E)
        // Keep Going on 1st Neighbour
        DFSHelper(graph, source, new HashSet<>());
    }

    public static void DFSHelper(ArrayList<Edge>[] graph, int current, HashSet<Integer> Visited) {
        if (Visited.contains(current)) {
            return;
        }

        System.out.print(current + " ");
        Visited.add(current);

        for (Edge e : graph[current]) {
            DFSHelper(graph, e.dest, Visited);
        }

    }
}
