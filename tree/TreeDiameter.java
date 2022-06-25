package LeetCode.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/tree-diameter/solution/
public class TreeDiameter {
    private int max = 0;

    public int treeDiameter(int[][] edges) {
        if (edges.length == 0) return 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] arr : edges) {
            map.putIfAbsent(arr[0], new HashSet<>());
            map.putIfAbsent(arr[1], new HashSet<>());
            map.get(arr[0]).add(arr[1]);
            map.get(arr[1]).add(arr[0]);
        }
        boolean[] seen = new boolean[edges.length + 1];
        dfs(map, seen, 0);
        return max;
    }

    private int dfs(Map<Integer, Set<Integer>> map, boolean[] seen, int curr) {
        if (seen[curr]) return -1;
        seen[curr] = true;

        int currMax = 0;
        for (int i : map.get(curr)) {
            int buff = 1 + dfs(map, seen, i);
            this.max = Math.max(this.max, buff + currMax);
            currMax = Math.max(currMax, buff);
        }
        return currMax;
    }

    public static void main(String[] args) {
        TreeDiameter treeDiameter = new TreeDiameter();
        System.out.println(treeDiameter.treeDiameter(new int[][]{{0,1},{0,2}}));
    }
}
