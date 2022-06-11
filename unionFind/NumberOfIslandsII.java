package LeetCode.unionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/number-of-islands-ii/
public class NumberOfIslandsII {
    private final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};


    //O(nm) for initialization and O(L) for each operation
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> output = new ArrayList<>(positions.length);
        UnionFind unionFind = new UnionFind(m * n);
        for (int[] position : positions) {
            int curr = getNumberFromCoordinates(position[0], position[1], n);
            unionFind.open(curr);
            for (int[] dir : DIRECTIONS) {
                int x = position[0] + dir[0];
                int y = position[1] + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n) continue;
                unionFind.union(getNumberFromCoordinates(x, y, n), curr);
            }
            output.add(unionFind.islands);
        }
        return output;
    }

    private int getNumberFromCoordinates(int x, int y, int n) {
        return x * n + y;
    }

    private class UnionFind{
        private int[] arr;
        private int[] sizes;
        private boolean[] opened;
        private int islands;

        public UnionFind(int n) {
            this.islands = 0;
            this.arr = new int[n];
            this.sizes = new int[n];
            Arrays.fill(sizes, 1);
            for (int i = 0; i < n; i++) this.arr[i] = i;
            this.opened = new boolean[n];
        }

        private int find(int i) {
            int buff = i;
            while (arr[i] != i) i = arr[i];
            arr[buff] = i;
            return i;
        }

        private void open(int i) {
            if (opened[i]) return;
            opened[i] = true;
            islands++;
        }

        private void union(int i, int j) {
            if (!opened[i] || !opened[j]) return;
            int x = find(i);
            int y = find(j);
            if (x == y) return;
            if (sizes[x] > sizes[y]) {
                arr[y] = x;
                sizes[x] += sizes[y];
            } else {
                arr[x] = y;
                sizes[y] += sizes[x];
            }
            islands--;
        }
    }

    public static void main(String[] args) {
        NumberOfIslandsII numberOfIslandsII = new NumberOfIslandsII();
        System.out.println(numberOfIslandsII.numIslands2(3, 3, new int[][]{{0,0},{0,1},{1,2},{2,1}}));
    }
}
