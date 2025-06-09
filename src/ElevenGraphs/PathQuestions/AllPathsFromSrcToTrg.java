package ElevenGraphs.PathQuestions;

import ElevenGraphs.Traversals.Edge;

import java.util.*;

import static ElevenGraphs.Creation.UndirectedUnweightedGraphAdjacencyList.createGraph;


public class AllPathsFromSrcToTrg {

    private static void pathsFromSrcToTrg(ArrayList<Edge>[] graph, int curr, int trg, String path, boolean[] isVisited) {

        if (curr == trg) {
            System.out.println(path);
            return;
        }

        for (Edge edge : graph[curr]) {
            if (!isVisited[edge.dest]) {
                isVisited[curr] = true;
                pathsFromSrcToTrg(graph, edge.dest, trg, path + edge.dest, isVisited);
                isVisited[curr] = false;
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;

        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        int curr = 0;
        int trg = 5;

        pathsFromSrcToTrg(graph, curr, trg, curr + "", new boolean[V]);
    }
}
