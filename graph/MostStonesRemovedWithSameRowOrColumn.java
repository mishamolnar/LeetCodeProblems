package LeetCode.graph;

import java.util.*;

//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
public class MostStonesRemovedWithSameRowOrColumn {

    public int removeStones(int[][] stones) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < stones.length - 1; i++) {
            for(int j = i + 1; j < stones.length; j++) {
                if(stones[i][0]  == stones[j][0] || stones[i][1] == stones[j][1]) { //grapth computing
                    graph.computeIfAbsent(i, k -> new ArrayList()).add(j);
                    graph.computeIfAbsent(j, k -> new ArrayList()).add(i);
                }
            }
        }

        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            if (!set.contains(i)) res += DFS(graph, set, i);
        }

        return res;
    }

    private int DFS(HashMap<Integer, List<Integer>> graph, Set<Integer> used, int root) {
        int res = 1;
        used.add(root);
        if (!graph.containsKey(root)) return res;

        for (Integer v : graph.get(root)) {
            if (!used.contains(v)) res += DFS(graph, used, v);
        }

        return res;
    }

}
