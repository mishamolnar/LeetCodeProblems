package LeetCode.unionFind;

import java.util.Arrays;

//https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/solution/
public class TheEarliestMomentWhenEveryoneBecomeFriends {

    // O(M * a(N))  M - number of logs, a(N) ackerman function
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        UnionFind unionFind = new UnionFind(n);
        for (int[] log : logs) {
            unionFind.union(log[1], log[2]);
            if (unionFind.size() == 1) return log[0];
        }
        return -1;
    }

    private class UnionFind{
        private int[] arr;
        private int[] size;
        private int islands;

        private int size() {
            return islands;
        }

        public UnionFind(int islands) {
            this.arr = new int[islands];
            this.size = new int[islands];
            this.islands = islands;
            Arrays.fill(size, 1);
            for (int i = 0; i < islands; i++) arr[i] = i;
        }

        private int find(int a) {
            int buff = a;
            while (arr[a] != a) a = arr[a];
            arr[buff] = a;
            return a;
        }

        private void union(int a, int b) {
            int x = find(a);
            int y = find(b);
            if (x == y) return;
            if (size[x] > size[y]) {
                size[x] += size[y];
                arr[x] = y;
            } else {
                size[y] += size[x];
                arr[y] = x;
            }
            islands--;
        }
    }
}
