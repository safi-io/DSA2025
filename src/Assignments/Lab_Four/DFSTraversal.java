package Assignments.Lab_Four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DFSTraversal {
    public static void DFS(ArrayList<Edge>[] graph, char src, HashMap<Character, Integer> charToIndex) {
        DFSHelper(graph, src, new HashSet<>(), charToIndex);
    }

    private static void DFSHelper(ArrayList<Edge>[] graph, char src, HashSet<Character> isVisited, HashMap<Character, Integer> charToIndex) {
        if (isVisited.contains(src)) {
            return;
        }

        System.out.print(" " + src + "->");
        isVisited.add(src);

        for (Edge e : graph[charToIndex.get(src)]) {
            DFSHelper(graph, e.dest, isVisited, charToIndex);
        }
    }
}
