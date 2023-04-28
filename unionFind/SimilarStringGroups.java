package LeetCode.unionFind;

import java.util.Arrays;

public class SimilarStringGroups {
    public int numSimilarGroups(String[] strs) {
        UnionFind unionFind = new UnionFind(strs.length);
        for (int i = 0; i < strs.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (!unionFind.connected(i, j) && checkSimilarity(strs[i], strs[j])) {
                    unionFind.connect(i, j);
                }
            }
        }
        return unionFind.size;
    }

    private boolean checkSimilarity(String s1, String s2) {
        int first = -1, second = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (first == -1)
                    first = i;
                else if (second == -1)
                    second = i;
                else return false;
            }
        }
        return first == -1 || (s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first));
    }


    private class UnionFind {
        private int[] sizes;
        private int[] root;
        private int size;

        public UnionFind(int size) {
            this.size = size;
            sizes = new int[size];
            Arrays.fill(sizes, 1);
            root = new int[size];
            for (int i = 0; i < root.length; i++) {
                root[i] = i;
            }
        }

        private int find(int i) {
            int initial = i;
            while (root[i] != i) {
                i = root[i];
            }
            root[initial] = i;
            return i;
        }

        private boolean connected(int i, int j) {
            return find(i) == find(j);
        }

        private void connect(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ) {
                return;
            } else if (sizes[rootI] > sizes[rootJ]) {
                root[rootJ] = rootI;
            } else {
                root[rootI] = rootJ;
            }
            size--;
        }
    }
}
