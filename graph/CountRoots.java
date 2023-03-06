package LeetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CountRoots {
    private int correct;
    private int answer;
    private int k;

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        this.k = k;
        Map<Integer, Set<Integer>> G = new HashMap<>();
        for (int[] edge : edges) {
            G.putIfAbsent(edge[0], new HashSet<>());
            G.putIfAbsent(edge[1], new HashSet<>());
            G.get(edge[1]).add(edge[0]);
            G.get(edge[0]).add(edge[1]);
        }
        Map<Integer, Set<Integer>> guess = new HashMap<>();
        for (int[] ints : guesses) {
            guess.putIfAbsent(ints[0], new HashSet<>());
            guess.get(ints[0]).add(ints[1]);
        }
        initDfs(0, -1, G, guess);
        if (correct >= k) answer++;
        for (Integer next : G.get(0)) reRooting(next, 0, G, guess);
        return answer;
    }

    private void reRooting(int curr, int prev, Map<Integer, Set<Integer>> G, Map<Integer, Set<Integer>> guess) {
        if (guess.getOrDefault(prev, Collections.emptySet()).contains(curr)) {
            correct--;
        }
        if (guess.getOrDefault(curr, Collections.emptySet()).contains(prev)) {
            correct++;
        }
        if (correct >= k) this.answer++;
        for (Integer next : G.getOrDefault(curr, Collections.emptySet())) {
            if (next == prev) continue;
            reRooting(next, curr, G, guess);
        }
    }

    private void initDfs(int curr, int prev, Map<Integer, Set<Integer>> G, Map<Integer, Set<Integer>> guess) {
        if (guess.containsKey(prev) && guess.get(prev).contains(curr)) {
            correct++;
        }
        for (Integer next : G.getOrDefault(curr, Collections.emptySet())) {
            if (next == prev) continue;
            initDfs(next, curr, G, guess);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CountRoots().rootCount(new int[][]{{0,1},{1,2},{1,3},{4,2}}, new int[][]{{1,3},{0,1},{1,0},{2,4}}, 3));
    }
}
