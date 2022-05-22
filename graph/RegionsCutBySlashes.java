package LeetCode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/regions-cut-by-slashes/
public class RegionsCutBySlashes {

    public static void main(String[] args) {
        RegionsCutBySlashes regionsCutBySlashes = new RegionsCutBySlashes();
        System.out.println(regionsCutBySlashes.regionsBySlashes(new String[]{"  ","  "}));
    }

    public int regionsBySlashes(String[] grid) {
        int len = grid.length;
        List<Integer>[] G = new List[(len + 1) * (len  + 1)];
        boolean[] marked = new boolean[G.length];
        Set<Integer> added = new HashSet<>();
        for (int i = 0; i < G.length; i++) G[i] = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char c = grid[i].charAt(j);
                if (c == '/') {
                    connect(G, i * (len + 1) + j + 1, (i + 1) * (len + 1) + j, marked, added);
                    added.add(i * (len + 1) + j + 1);
                    added.add((i + 1) * (len + 1) + j);
                }
                if (c == '\\') {
                    connect(G, i * (len + 1) + j, (i + 1) * (len + 1) + j + 1, marked, added);
                    added.add(i * (len + 1) + j);
                    added.add((i + 1) * (len + 1) + j + 1);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (added.contains(i * (len + 1) + j + 1)) continue;
                if (!added.contains(i * (len + 1) + j + 2) && j < grid[i].length() - 1) connect(G, i * (len + 1) + j + 1, i * (len + 1) + j + 2, marked, added);
                if (!added.contains(i * (len + 1) + j) && j > 0) connect(G, i * (len + 1) + j + 1, i * (len + 1) + j, marked, added);
                if (!added.contains((i - 1) * (len + 1) + j + 1) && i > 0) connect(G, i * (len + 1) + j + 1, (i - 1) * (len + 1) + j + 1, marked, added);
                if (!added.contains((i + 1) * (len + 1) + j + 1) && i < grid.length - 1) connect(G, i * (len + 1) + j + 1, (i + 1) * (len + 1) + j + 1, marked, added);
            }
        }
        int res = 0;
        for (int i = 0; i < G.length; i++) {
            if (!marked[i]) {
                res++;
                dfs(G, i, marked);
            }
        }
        return res;
    }

    private void dfs(List<Integer>[] G, int v, boolean[] marked) {
        for (Integer w : G[v]) {
            if (!marked[w]) {
                dfs(G, w, marked);
            }
        }
    }

    private void connect (List<Integer>[] G, int a, int b, boolean[] marked, Set<Integer> added) {
        if (a < 0 || b < 0 || a > marked.length || b > marked.length) return;
        added.add(a);
        added.add(b);
        G[a].add(b);
        G[b].add(a);
        marked[a] = true;
        marked[b] = true;
    }
}
