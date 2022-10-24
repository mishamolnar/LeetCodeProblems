package LeetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveDestination {
    private static final int MOD = 1_000_000_009;
    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] road : roads) {
            map.putIfAbsent(road[0], new ArrayList<>());
            map.putIfAbsent(road[1], new ArrayList<>());
            map.get(road[0]).add(new int[]{road[1], road[2]}); //distination, distance
            map.get(road[1]).add(new int[]{road[0], road[2]});
        }

        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); //0 dest, 1 distance
        pq.add(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[1] > dist[curr[0]])
                continue;
            for (int[] next : map.getOrDefault(curr[0], Collections.emptyList())) {
                if (next[1] + curr[1] > dist[next[0]]) {
                    continue;
                } else if (next[1] + curr[1] < dist[next[0]]) {
                    dist[next[0]] = next[1] + curr[1];
                    ways[next[0]] = ways[curr[0]];
                    pq.add(new int[]{next[0], dist[next[0]]});
                } else {
                    ways[next[0]] += ways[curr[0]];
                }
            }
        }
        return ways[n - 1];
    }

    public static void main(String[] args) {
        NumberOfWaysToArriveDestination number = new NumberOfWaysToArriveDestination();
        System.out.println(number.countPaths(7, new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}}));
    }
}
