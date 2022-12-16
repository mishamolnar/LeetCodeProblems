package LeetCode.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DivideNodesINtoGroups {
    public int magnificentSets(int n, int[][] edges) {
        Map<Integer, List<Integer>> res  = new HashMap<>();
        for (int[] edge : edges) {
            res.putIfAbsent(edge[0], new ArrayList<>());
            res.putIfAbsent(edge[1], new ArrayList<>());
            res.get(edge[0]).add(edge[1]);
            res.get(edge[1]).add(edge[0]);
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int grp = bfs(i, res, n + 1);
            if (grp == -1) return -1;
            else ans = Math.max(ans, grp);
        }
        return ans;
    }

    private int bfs(int start, Map<Integer, List<Integer>> G, int edges) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] colors = new int[edges];
        int res = 0;
        colors[start] = 1;
        deque.add(start);
        while (!deque.isEmpty()) {
            for (int i = deque.size(); i > 0; i--) {
                int curr = deque.poll();
                res = Math.max(res, colors[curr]);
                for (Integer next : G.getOrDefault(curr, Collections.emptyList())) {
                    if (colors[next] == 0) {
                        colors[next] = colors[curr] + 1;
                        deque.add(next);
                    } else if (Math.abs(colors[next] - colors[curr]) != 1) {
                        return -1;
                    }
                }
            }
        }
        return res;
    }
}
