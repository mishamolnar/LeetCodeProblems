package LeetCode.graph;

import LeetCode.matrixes.ShortestPathInBinaryMatrix;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestPathWithAlternatingColor {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, Set<Integer>> red = new HashMap<>();
        Map<Integer, Set<Integer>> blue = new HashMap<>();
        for (int[] edge: redEdges) {
            red.putIfAbsent(edge[0], new HashSet<>());
            red.get(edge[0]).add(edge[1]);
        }
        for (int[] edge: blueEdges) {
            blue.putIfAbsent(edge[0], new HashSet<>());
            blue.get(edge[0]).add(edge[1]);
        }
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        Queue<int[]> q = new ArrayDeque<>(); // 0 - edge, 1 - prevcolor (0 = blue), 2 - curr length;
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        for (int next : red.getOrDefault(0, Collections.emptySet())) {
            if (next != 0) {
                q.add(new int[]{next, 1, 1});
            }
        }
        for (int next : blue.getOrDefault(0, Collections.emptySet())) {
            if (next != 0) {
                q.add(new int[]{next, 0, 1});
            }
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (arr[curr[0]] == -1)
                arr[curr[0]] = curr[2];
            Set<Integer> neib = curr[1] == 0 ? red.getOrDefault(curr[0], Collections.emptySet()) : blue.getOrDefault(curr[0], Collections.emptySet());
            for (int next : neib) {
                if (!visited.contains(curr[1] == 0 ? next : -next) && next != curr[0]) {
                    q.add(new int[]{next, curr[1] == 0 ? 1 : 0 ,curr[2] + 1});
                }
            }
            if (neib.contains(curr[0])) {
                for (int next : curr[1] == 1 ? red.getOrDefault(curr[0], Collections.emptySet()) : blue.getOrDefault(curr[0], Collections.emptySet())) {
                    if (!visited.contains(curr[1] == 0 ? -next : next) && next != curr[0]) {
                        q.add(new int[]{next, curr[1],curr[2] + 2});
                    }
                }
            }
            visited.add(curr[1] == 0 ? -curr[0] : curr[0]);
        }
        return arr;
    }

    public static void main(String[] args) {
        ShortestPathWithAlternatingColor shortestPathWithAlternatingColor = new ShortestPathWithAlternatingColor();
        System.out.println(shortestPathWithAlternatingColor.shortestAlternatingPaths(6,
                new int[][]{{3,4},{1,5},{1,0},{5,3},{2,1},{2,0},{0,3},{1,2},{5,2},{1,4},{1,3},{5,0},{4,5},{5,5},{3,3}},
                new int[][]{{2,5},{3,0},{1,2},{4,3},{3,4},{0,4},{5,0},{5,2},{1,0},{0,2}}));
    }
}
