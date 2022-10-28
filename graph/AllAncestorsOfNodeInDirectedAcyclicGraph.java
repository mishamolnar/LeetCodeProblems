package LeetCode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class AllAncestorsOfNodeInDirectedAcyclicGraph {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> G = new HashMap<>();
        int[] inNode = new int[n];
        for (int[] edge : edges) {
            G.putIfAbsent(edge[0], new ArrayList<>());
            G.get(edge[0]).add(edge[1]);
            inNode[edge[1]]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(inNode[a], inNode[b]));
        List<Set<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pq.add(i);
            res.add(new HashSet<>());
        }
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            for (Integer next : G.getOrDefault(curr, Collections.emptyList())) {
                res.get(next).add(curr);
                res.get(next).addAll(res.get(curr));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Set<Integer> re : res) {
            List<Integer> an = new ArrayList<>(re);
            an.sort(Integer::compare);
            ans.add(an);
        }
        return ans;
    }

    public static void main(String[] args) {
        AllAncestorsOfNodeInDirectedAcyclicGraph ancestors = new AllAncestorsOfNodeInDirectedAcyclicGraph();
        System.out.println(ancestors.getAncestors(8, new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}}));
    }
}
