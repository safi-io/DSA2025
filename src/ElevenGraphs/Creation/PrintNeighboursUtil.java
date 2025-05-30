package ElevenGraphs.Creation;

import ElevenGraphs.Traversals.Edge;

import java.util.ArrayList;

public class PrintNeighboursUtil {
    public static void printNeighbours(ArrayList<Edge>[] graph, int index) {
        for (int i = 0; i < graph[index].size(); i++) {
            System.out.println(i + 1 + " neighbour of " + index + " is: " + graph[index].get(i).dest);
        }
    }
}
