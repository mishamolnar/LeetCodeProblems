package LeetCode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/keys-and-rooms/
public class NumberOfConnectedComponents {

    public static void main(String[] args) {
        NumberOfConnectedComponents numberOfConnectedComponents = new NumberOfConnectedComponents();
        System.out.println(numberOfConnectedComponents.numberOfConnectedComponents(5, new int[][]{})); //5
        System.out.println(numberOfConnectedComponents.numberOfConnectedComponents(5, new int[][]{{0,1},{1,2},{3,4}})); // 2
        System.out.println(numberOfConnectedComponents.numberOfConnectedComponents(5, new int[][]{{0,1},{1,2},{3,4},{2,3}})); //1
    }

    //time and space - O(e + v)
    public int numberOfConnectedComponents(int n, int[][] edges) {
        List<Set<Integer>> G = new ArrayList<>();
        for (int i = 0; i < n; i++) G.add(new HashSet<>());
        for (int[] edge : edges) {
            G.get(edge[0]).add(edge[1]);
            G.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                DFS(i, G, visited);
                count++;
            }
        }
        return count;
    }

    private void DFS(int v, List<Set<Integer>> G, boolean[] visited) {
        if (visited[v]) return;
        visited[v] = true;
        for (Integer w : G.get(v)) {
            DFS(w, G, visited);
        }
    }
}
