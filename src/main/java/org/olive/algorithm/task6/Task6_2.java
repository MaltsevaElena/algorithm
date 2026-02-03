package org.olive.algorithm.task6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Task6_2.
 *
 * @author Elena Maltseva
 */
public class Task6_2 {

    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;

    private static int[] visited;
    private static List<Integer> result;
    private static boolean hasCycle;

    public static List<Integer> topologicalSortDFS(int[][] adjMatrix) {
        int numVertices = adjMatrix.length;
        if (numVertices == 0) {
            return new ArrayList<>();
        }

        visited = new int[numVertices];
        result = new LinkedList<>();
        hasCycle = false;

        for (int i = 0; i < numVertices; i++) {
            if (visited[i] == WHITE) {
                dfs(i, adjMatrix);
                if (hasCycle) {
                    System.out.println("Граф содержит цикл. Топологическая сортировка невозможна.");
                    return new ArrayList<>();
                }
            }
        }
        return result;
    }

    private static void dfs(int u, int[][] adjMatrix) {
        visited[u] = GRAY;

        for (int v = 0; v < adjMatrix.length; v++) {
            if (adjMatrix[u][v] > 0) {
                if (visited[v] == GRAY) {
                    hasCycle = true;
                    return;
                }
                if (visited[v] == WHITE) {
                    dfs(v, adjMatrix);
                    if (hasCycle) {
                        return;
                    }
                }
            }
        }

        visited[u] = BLACK;
        ((LinkedList<Integer>) result).addFirst(u);
    }

}
