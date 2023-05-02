package LeetCode.unionFind;

import java.util.Arrays;

public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);//edge[0] = 1
        UnionFind bob = new UnionFind(n);//edge[0] = 2
        int res = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                res += alice.connect(edge[1] - 1, edge[2] - 1) ? 0 : 1;
                bob.connect(edge[1], edge[2]);
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                res += alice.connect(edge[1] - 1, edge[2] - 1) ? 0 : 1;
            } if (edge[0] == 1) {
                res += bob.connect(edge[1] - 1, edge[2] - 1) ? 0 : 1;
            }
        }
        return (alice.size == 1 && bob.size == 1) ? res : -1;
    }

    private class UnionFind {
        int size;
        int[] roots;
        int[] sizes;


        public UnionFind(int size) {
            this.size = size;
            roots = new int[size];
            sizes = new int[size];
            Arrays.fill(sizes, 1);
            for (int i = 0; i < roots.length; i++) {
                roots[i] = i;
            }
        }

        private int find(int i) {
            int buff = i;
            while (i != roots[i]) {
                i = roots[i];
            }
            roots[buff] = i;
            return i;
        }

        private boolean connect(int i, int j) {//if were connected - false
            int rootI = find(i);
            int rootJ = find(j);
            if (rootJ == rootI) {
                return false;
            } else if (sizes[rootI] > sizes[rootJ]) {
                roots[rootJ] = rootI;
                sizes[rootI] += sizes[rootJ];
            } else {
                roots[rootI] = rootJ;
                sizes[rootJ] += sizes[rootI];
            }
            size--;
            return true;
        }
    }
}
