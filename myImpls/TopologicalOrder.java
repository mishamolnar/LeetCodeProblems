package LeetCode.myImpls;

import LeetCode.graph.LoudAndRich;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalOrder {
    private boolean[] marked;
    private Stack<Integer> topologicalOrder;

    public static void main(String[] args) {
        LoudAndRich loudAndRich = new LoudAndRich();
        loudAndRich.loudAndRich(new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}}, new int[]{3,2,5,4,6,1,7,0});
    }

    public int[] topological(int[][] graph, int length) {
        marked = new boolean[length];
        topologicalOrder = new Stack<>();
        List<Integer>[] G = new List[length];
        for (int i = 0; i < length; i++) G[i] = new ArrayList<>();
        for (int[] ints : graph) G[ints[0]].add(ints[1]);
        for (int i = 0; i < length; i++) if (!marked[i]) dfs(G, i);
        return null;
    }

    private void dfs(List<Integer>[] G, int v) {
        marked[v] = true;
        for (Integer w : G[v]) {
            if (!marked[w]) dfs(G, w);
        }
        topologicalOrder.push(v);
    }
}
