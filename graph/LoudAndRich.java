package LeetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/loud-and-rich/
public class LoudAndRich {

    public static void main(String[] args) {
        LoudAndRich loudAndRich = new LoudAndRich();
        System.out.println(Arrays.toString(loudAndRich.loudAndRich(new int[][]{{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}}, new int[]{3, 2, 5, 4, 6, 1, 7, 0})));
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<Integer>[] G = new List[quiet.length];
        int[] result = new int[quiet.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < quiet.length; i++) G[i] = new ArrayList<>();
        for (int[] ints : richer) G[ints[1]].add(ints[0]);
        for (int i = 0; i < quiet.length; i++) dfs(G, i, result, quiet);
        return result;
    }

    private int dfs(List<Integer>[] G, int v, int[] result, int[] quiet) {
        if (result[v] >= 0) return result[v];
        result[v] = v;
        for (Integer w : G[v]) {
            if (quiet[result[v]] > quiet[dfs(G, w, result, quiet)]) result[v] = result[w];
        }
        return result[v];
    }
}
