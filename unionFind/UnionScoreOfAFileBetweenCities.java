package LeetCode.unionFind;

public class UnionScoreOfAFileBetweenCities {
    public int minScore(int n, int[][] roads) {
        UnionFind uf = new UnionFind(n + 1);
        for (int[] road : roads) {
            uf.connect(road[0], road[1]);
        }
        int ans = Integer.MAX_VALUE;
        for (int[] road : roads) {
            if (uf.isConnected(1, road[1])) {
                ans = Math.min(ans, road[2]);
            }
        }
        return ans;
    }

    private class UnionFind {
        private int[] root;
        private int[] size;

        UnionFind(int size) {
            this.root = new int[size];
            this.size = new int[size];
            for (int i = 0; i < size; i++) {
                this.root[i] = i;
                this.size[i] = 1;
            }
        }

        private boolean isConnected(int i, int j) {
            return find(i) == find(j);
        }

        private int find(int v) {
            int buff = v;
            while (root[buff] != buff) {
                buff = root[buff];
            }
            root[v] = buff;
            return buff;
        }

        private void connect(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (size[rootI] > size[rootJ]) {
                root[rootJ] = rootI;
                size[rootI] += size[rootJ];
            } else {
                root[rootI] = rootJ;
                size[rootJ] += size[rootI];
            }
        }
    }
}
