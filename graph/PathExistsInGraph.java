package LeetCode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> G = new HashMap<>();
        for (int[] edge : edges) {
            G.putIfAbsent(edge[0], new ArrayList<>());
            G.putIfAbsent(edge[1], new ArrayList<>());
            G.get(edge[0]).add(edge[1]);
            G.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(source, destination, G, visited);
    }

    private boolean dfs(int curr, int target, Map<Integer, List<Integer>> G, boolean[] visited) {
        if (curr == target)
            return true;
        if (visited[curr])
            return false;
        visited[curr] = true;
        for (Integer next : G.get(curr)) {
            if (dfs(next, target, G, visited))
                return true;
        }
        return false;
    }
}
