package LeetCode.myImpls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CountRoots {

    public static void main(String[] args) {
        System.out.println(new CountRoots().rootCount(new int[][]{{0,1},{1,2},{1,3},{4,2}}, new int[][]{{1,3},{0,1},{1,0},{2,4}}, 3));
    }

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        Map<Integer, Set<Integer>> G = new HashMap<>();
        for (int[] edge : edges) {
            G.putIfAbsent(edge[0], new HashSet<>());
            G.putIfAbsent(edge[1], new HashSet<>());
            G.get(edge[1]).add(edge[0]);
            G.get(edge[0]).add(edge[1]);
        }
        int[] counters = new int[edges.length + 1];
        Arrays.fill(counters, guesses.length);
        HashMap<Integer, HashMap<Integer, List<Integer>>> memo = new HashMap<>();
        for (int[] guess : guesses) {
            dfs(guess[1], guess[0], G,memo, counters);
        }
        int res = 0;
        for (int counter : counters) {
            if (counter >= k) {
                res++;
            }
        }
        return res;
    }

    private List<Integer> dfs(int curr, int prev, Map<Integer,
            Set<Integer>> G, HashMap<Integer, HashMap<Integer, List<Integer>>> memo, int[] counters) {
        if (memo.containsKey(prev) && memo.get(prev).containsKey(curr)) {
            for (Integer child : memo.get(prev).get(curr)) {
                counters[child]--;
            }
            return memo.get(prev).get(curr);
        }
        counters[curr]--;
        List<Integer> list = new ArrayList<>();
        list.add(curr);
        for (Integer next : G.get(curr)) {
            if (next == prev) continue;
            list.addAll(dfs(next, curr, G, memo, counters));
        }
        memo.putIfAbsent(prev, new HashMap<>());
        memo.get(prev).putIfAbsent(curr, list);
        return list;
    }
}
