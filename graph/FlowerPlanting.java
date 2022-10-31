package LeetCode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FlowerPlanting {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, Set<Integer>> G = new HashMap<>();
        int[] res = new int[n];
        List<Set<Integer>> available = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> curr = new HashSet<>(Set.of(1, 2, 3, 4));
            available.add(curr);
        }
        for (int[] path : paths) {
            G.putIfAbsent(path[0], new HashSet<>());
            G.putIfAbsent(path[1], new HashSet<>());
            G.get(path[0]).add(path[1]);
            G.get(path[1]).add(path[0]);
        }
        for (int i = 0; i < n; i++) {
            dfs(G, available, res, i + 1);
        }
        return res;
    }

    private void dfs(Map<Integer, Set<Integer>> G, List<Set<Integer>> available, int[] res, int curr) {
        int color = available.get(curr - 1).iterator().next();
        available.get(curr - 1).remove(color);
        for (Integer neib : G.getOrDefault(curr, Collections.emptySet())) {
            available.get(neib - 1).remove(color);
        }
        res[curr - 1] = color;
    }
}
