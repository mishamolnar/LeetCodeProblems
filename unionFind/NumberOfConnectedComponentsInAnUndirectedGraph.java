package LeetCode.unionFind;

import java.util.*;

//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/submissions/
public class NumberOfConnectedComponentsInAnUndirectedGraph {

    public static void main(String[] args) {
        NumberOfConnectedComponentsInAnUndirectedGraph numberOfConnectedComponentsInAnUndirectedGraph = new NumberOfConnectedComponentsInAnUndirectedGraph();
        System.out.println(numberOfConnectedComponentsInAnUndirectedGraph.countComponentsUnionFind(5, new int[][]{{0,1},{1,2},{0,2},{3,4}}));
    }

    //DFS, O(E+V) space and time
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            result++;
            Deque<Integer> stack = new ArrayDeque<>();
            stack.add(i);
            visited[i] = true;
            while (!stack.isEmpty()) {
                int curr = stack.pop();
                for (Integer j : adj[curr]) {
                    if (visited[j]) continue;
                    visited[j] = true;
                    stack.add(j);
                }
            }
        }
        return result;
    }

    //DFS, O(E+V) space
    // time O((E+V) * α(n)) ackerman function
    public int countComponentsUnionFind(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            unionFind.connect(edge[0], edge[1]);
        }
        return unionFind.size();
    }

    private class UnionFind {
        private int n;
        private int[] arr;
        private int[] size;

        public UnionFind(int n) {
            this.n = n;
            this.arr = new int[n];
            this.size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) arr[i] = i;
        }

        private int find(int a) {
            int buff = a;
            while (arr[buff] != buff) {
                buff = arr[buff];
            }
            arr[a] = buff;
            return arr[a];
        }

        private void connect(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot == bRoot) return;
            if (size[aRoot] > size[bRoot]) {
                size[aRoot] += size[bRoot];
                arr[aRoot] = arr[bRoot];
            } else {
                size[bRoot] += size[aRoot];
                arr[bRoot] = arr[aRoot];
            }
            n--;
        }

        private int size() {
            return n;
        }
    }
}
