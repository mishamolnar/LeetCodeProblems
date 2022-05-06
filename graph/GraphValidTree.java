package LeetCode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//link - https://www.lintcode.com/problem/178/description
public class GraphValidTree {
    public static void main(String[] args) {
        GraphValidTree graphValidTree = new GraphValidTree();
        System.out.println(graphValidTree.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
    }

    // time and space - O(e + v)
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        List<Set<Integer>> G = new ArrayList<>(n);
        for (int i = 0; i < n; i++) G.add(new HashSet<>());
        boolean[] visited = new boolean[n];
        for (int[] edge : edges) {
            G.get(edge[0]).add(edge[1]);
            G.get(edge[1]).add(edge[0]);
        }
        if (!DFS(0, -1, visited, G)) return false;
        for (boolean b : visited) if (!b) return false;
        return true;
    }

    // по суті детектим коло в undirected graph
    private boolean DFS(int current, int prev, boolean[] visited, List<Set<Integer>> G) {
        if (visited[current]) return false;
        visited[current] = true;
        for (Integer w : G.get(current)) {
            if (w == prev) continue;
            if (!DFS(w, current, visited, G)) return false;
        }
        return true;
    }
}
