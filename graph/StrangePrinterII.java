package LeetCode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrangePrinterII {
    public boolean isPrintable(int[][] targetGrid) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, int[]> edges = new HashMap<>();
        for (int i = 0; i < targetGrid.length; i++) {
            for (int j = 0; j < targetGrid[0].length; j++) {
                edges.putIfAbsent(targetGrid[i][j], new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE});
                normalize(i, j, edges.get(targetGrid[i][j]));
            }
        }
        for (int i = 0; i < targetGrid.length; i++) {
            for (int j = 0; j < targetGrid[0].length; j++) {
                for (Map.Entry<Integer, int[]> entry : edges.entrySet()) {
                    if (targetGrid[i][j] != entry.getKey() && contains(i, j, entry.getValue())) {
                        graph.putIfAbsent(entry.getKey(), new ArrayList<>());
                        graph.get(entry.getKey()).add(targetGrid[i][j]);
                    }
                }
            }
        }
        Map<Integer, Boolean> visited = new HashMap<>();
        Map<Integer, Boolean> inStack = new HashMap<>();
        for (Integer vertex : graph.keySet()) {
            if (!visited.getOrDefault(vertex, false) && !dfs(vertex, graph, visited, inStack))
                return false;
        }
        return true;
    }

    private boolean dfs(int curr, Map<Integer, List<Integer>> graph, Map<Integer, Boolean> visited, Map<Integer, Boolean> inStack) {
        if (inStack.getOrDefault(curr, false)) return false;
        if (visited.getOrDefault(curr, false)) return true;

        inStack.put(curr, true);
        visited.put(curr, true);

        boolean res = true;
        for (Integer next : graph.getOrDefault(curr, Collections.emptyList())) {
            res &= dfs(next, graph, visited, inStack);
        }
        inStack.put(curr, false);
        return res;
    }

    private boolean contains(int i, int j, int[] edge) {
        return i >= edge[0] && j >= edge[1] && i <= edge[2] && j <= edge[3];
    }

    private void normalize(int i, int j, int[] edges) {
        edges[0] = Math.min(edges[0], i);
        edges[2] = Math.max(edges[2], i);
        edges[1] = Math.min(edges[1], j);
        edges[3] = Math.max(edges[3], j);
    }
}
