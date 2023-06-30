package LeetCode.unionFind;

import java.util.Arrays;

public class LastDayWhereYouCanStillCross {
    private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    public int latestDayToCross(int length, int width, int[][] cells) {
        boolean[][] water = new boolean[length][width];
        UnionFind unionFind = new UnionFind(length * width + 2);
        int len = length * width;
        int left = len, right = len + 1;
        for (int i = 0; i < cells.length; i++) {
            int r = cells[i][0] - 1, c = cells[i][1] - 1;
            water[r][c] = true;
            for (int[] dir : DIRECTIONS) {
                water[r][c] = true;
                int rNext = r + dir[0], cNext = c + dir[1];
                if (rNext == -1 || rNext == length)
                    continue;
                if (cNext == -1) {
                    unionFind.connect(getNumber(r, c, width), left);
                }
                else if (cNext == width) {
                    unionFind.connect(getNumber(r, c, width), right);
                } else if (water[rNext][cNext])
                    unionFind.connect(getNumber(r, c, width), getNumber(rNext, cNext, width));
            }
             if (unionFind.connected(left, right))
                 return i;
        }
        return -1;
    }

    private int getNumber(int r, int c, int width) {
        return r * width + c;
    }

    private class UnionFind {
        private int[] root;
        private int[] size;

        public UnionFind(int n) {
            this.root = new int[n];
            this.size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        private boolean connected(int i, int j) {
            return find(i) == find(j);
        }

        private int find(int i) {
            int buff = i;
            while (root[i] != i)
                i = root[i];
            root[buff] = i;
            return i;
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


    public static void main(String[] args) {
        LastDayWhereYouCanStillCross last = new LastDayWhereYouCanStillCross();
        System.out.println(last.latestDayToCross(2, 2, new int[][]{{1, 1}, {2, 1}, {1, 2}, {2, 2}}));
    }
}
