package LeetCode.unionFind;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DetonateTheMaximumBombs {
    public int maximumDetonation(int[][] bombs) {
        int len = bombs.length, res = 0;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (connected(bombs[i], bombs[j])) {
                    graph.putIfAbsent(i, new HashSet<>());
                    graph.get(i).add(j);
                    graph.putIfAbsent(j, new HashSet<>());
                    graph.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dfs(i, visited, graph));
        }
        return res;
    }

    private boolean connected(int[] bomb1, int[] bomb2) {
        int xDistance = Math.abs(bomb1[0] - bomb2[0]);
        int yDistance = Math.abs(bomb1[1] - bomb2[1]);
        double distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance);
        return distance <= Math.max(bomb1[2], bomb2[2]);
    }

    private int dfs(int i, boolean[] visited, Map<Integer, Set<Integer>> graph) {
        if (visited[i]) {
            return 0;
        }
        visited[i] = true;
        int res = 1;
        for (Integer j : graph.getOrDefault(i, Collections.emptySet())) {
            res += dfs(j, visited, graph);
        }
        return res;
    }
}
