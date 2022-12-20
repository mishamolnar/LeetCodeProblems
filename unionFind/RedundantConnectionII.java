package LeetCode.unionFind;

public class RedundantConnectionII {


    public int[] findRedundantDirectedConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length + 1);
        for (int[] edge : edges) {
            if (unionFind.connected(edge[0], edge[1]))
                return edge;
            unionFind.connect(edge[0], edge[1]);
        }
        return new int[]{-1, -1};
    }

    private class UnionFind {
        int[] vertexes;
        int[] size;

        public UnionFind(int n) {
            vertexes = new int[n];
            size = new int[n];
            for (int i = 0; i < vertexes.length; i++) {
                vertexes[i] = i;
                size[i] = 1;
            }
        }

        private int find(int a) {
            int start = a;
            while(vertexes[a] != a) a = vertexes[a];
            vertexes[start] = a;
            return a;
        }

        private boolean connected(int a, int b) {
            return find(a) == find(b);
        }

        private void connect(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (size[rootA] > size[rootB]) {
                vertexes[rootB] = vertexes[rootA];
                size[rootA] += size[rootB];
            } else {
                vertexes[rootA] = vertexes[rootB];
                size[rootB] += size[rootA];
            }
        }
    }
}
