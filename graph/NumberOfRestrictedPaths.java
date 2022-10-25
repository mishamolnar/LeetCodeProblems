package LeetCode.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class NumberOfRestrictedPaths {
    private static final int MOD = 1_000_000_007;
    public int countRestrictedPaths(int n, int[][] edges) {
        Map<Integer, List<int[]>> map = new HashMap<>();//0 - next, 1 dist
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(new int[]{edge[1], edge[2]});
            map.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        //0-next, 1-dist
        pq.add(new int[]{n, 0});
        dist[n] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (dist[curr[0]] != curr[1])
                continue;
            for (int[] next : map.get(curr[0])) {
                if (dist[next[0]] > curr[1] + next[1]) {
                    dist[next[0]] = curr[1] + next[1];
                    pq.add(new int[]{next[0], curr[1] + next[1]});
                }
            }
        }
        int[] ways = new int[n + 1];
        Arrays.fill(ways, -1);
        ways[n] = 1;
        return dfs(1, ways, dist, map);
    }

    private int dfs(int curr, int[] ways, int[] dist, Map<Integer, List<int[]>> map) {
        if (ways[curr] != -1)
            return ways[curr];
        int res = 0;
        for (int[] next : map.get(curr)) {
            if (dist[curr] <= dist[next[0]])
                continue;
            res += dfs(next[0], ways, dist, map);
            res %= MOD;
        }
        ways[curr] = res;
        return res;
    }


    public static void main(String[] args) {
        NumberOfRestrictedPaths numberOfRestrictedPaths = new NumberOfRestrictedPaths();
        System.out.println(numberOfRestrictedPaths.countRestrictedPaths(5, new int[][]{{1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}}));
    }
}
