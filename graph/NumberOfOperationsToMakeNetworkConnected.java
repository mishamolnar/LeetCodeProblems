package LeetCode.graph;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/number-of-operations-to-make-network-connected/submissions/
public class NumberOfOperationsToMakeNetworkConnected {

    public static void main(String[] args) {
        NumberOfOperationsToMakeNetworkConnected number = new NumberOfOperationsToMakeNetworkConnected();
        System.out.println(number.makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}}));
    }

    public int makeConnected(int n, int[][] connections) {
        List<Integer>[] G = new List[n];
        for (int i = 0; i < n; i++) G[i] = new ArrayList<>();
        for (int[] connection : connections) {
            G[connection[0]].add(connection[1]);
            G[connection[1]].add(connection[0]);
        }
        boolean[] marked = new boolean[n];
        int islands = 0;
        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                dfs(G, i, marked);
                islands++;
            }
        }
        return connections.length + 1 >= n ? islands - 1 : -1;
    }

    private void dfs(List<Integer>[] G, int v, boolean[] marked) {
        marked[v] = true;
        for (Integer w : G[v]) {
            if (!marked[w]) dfs(G, w, marked);
        }
    }
}
