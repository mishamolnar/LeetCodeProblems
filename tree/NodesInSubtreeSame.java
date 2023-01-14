package LeetCode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodesInSubtreeSame {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> G = new HashMap<>();
        for (int[] edge : edges) {
            G.putIfAbsent(edge[0], new ArrayList<>());
            G.putIfAbsent(edge[1], new ArrayList<>());
            G.get(edge[1]).add(edge[0]);
            G.get(edge[0]).add(edge[1]);
        }
        int[] ans = new int[n];
        dfs(0, -1, G, labels, ans);
        return ans;
    }

    private int[] dfs(int curr, int prev, Map<Integer, List<Integer>> G, String labels, int[] ans) {
        int[] res = new int[26];
        res[labels.charAt(curr) - 'a']++;
        System.out.println("curr " + curr + " before " + res[labels.charAt(curr) - 'a']);
        for (int next : G.getOrDefault(curr, Collections.emptyList())) {
            if (next == prev) continue;
            addToFirst(res, dfs(next, curr, G, labels, res));
        }
        System.out.println("curr " + curr + " after " + res[labels.charAt(curr) - 'a']);
        ans[curr] = res[labels.charAt(curr) - 'a'];
        System.out.println("answer is " + Arrays.toString(ans) + " for " + curr);
        return res;
    }

    private void addToFirst(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            a[i] += b[i];
        }
    }

    public static void main(String[] args) {
        NodesInSubtreeSame nodes = new NodesInSubtreeSame();
        System.out.println(nodes.countSubTrees(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, "abaedcd"));
    }

    public NodesInSubtreeSame() {
    }
}
