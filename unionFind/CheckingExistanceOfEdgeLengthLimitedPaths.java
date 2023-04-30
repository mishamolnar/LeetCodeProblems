package LeetCode.unionFind;

import java.util.Arrays;

public class CheckingExistanceOfEdgeLengthLimitedPaths {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        // q - query length
        //brute force -> get a query and iterate through the graph with dfs, or bfs. In this case
        //(n + e) * v
        //we can use unions find and sort queries and edge list. firstly add every edge that edge[2] < query[2]
        //to union find, then check if edges are connected
        //n long n + q log q + n * ackerman(n)
        int[][] q = new int[queries.length][4];
        for (int i = 0; i < queries.length; i++) {
            System.arraycopy(queries[i], 0, q[i], 0, queries[i].length);
            q[i][3] = i;
        }
        Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));
        Arrays.sort(q, (a, b) -> Integer.compare(a[2], b[2]));
        boolean[] res = new boolean[q.length];
        int edgePointer = 0;
        UnionFind unionFind = new UnionFind(n);
        for (int[] query : q) {
            while (edgePointer < edgeList.length && edgeList[edgePointer][2] < query[2]) {
                unionFind.connect(edgeList[edgePointer][0], edgeList[edgePointer][1]);
            }
            res[query[3]] = unionFind.connected(query[0], query[1]);
        }
        return res;
    }


    private class UnionFind {
        int[] sizes;
        int[] roots;

        public UnionFind(int n) {
            sizes = new int[n];
            roots = new int[n];
            Arrays.fill(sizes, 1);
            for (int i = 0; i < roots.length; i++) {
                roots[i] = i;
            }
        }

        private int find(int i) {
            int buff = i;
            while (roots[i] != i) {
                i = roots[i];
            }
            roots[buff] = i;
            return i;
        }

        private boolean connected(int i, int j) {
            return find(i) == find(j);
        }

        private void connect(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootJ == rootI) {
                return;
            } else if (sizes[rootI] > sizes[rootJ]) {
                roots[rootJ] = rootI;
                sizes[rootI] += sizes[rootJ];
            } else {
                roots[rootI] = rootJ;
                sizes[rootJ] += sizes[rootI];
            }
        }
    }
}
