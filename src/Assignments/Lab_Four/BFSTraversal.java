package Assignments.Lab_Four;

import java.util.*;

public class BFSTraversal {
    public static void BFS(ArrayList<Edge>[] graph, char src, HashMap<Character, Integer> charToIndex) {
        Queue<Character> qe = new LinkedList<>();
        qe.add(src);

        HashSet<Character> set = new HashSet<>();

        while (!qe.isEmpty()) {
            Character current = qe.remove();

            if (!set.contains(current)) {
                System.out.print(" " + current + "->");
                set.add(current);

                // Find Index of Character
                int idx = charToIndex.get(current);

                for (Edge edge : graph[idx]) {
                    qe.add(edge.dest);
                }
            }
        }

    }
}
