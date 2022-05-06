package LeetCode.unionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


// https://leetcode.com/problems/redundant-connection/
// time - O(nlogn) space - O(n)
public class RedundantConnection {

    public static void main(String[] args) {
        RedundantConnection redundantConnection = new RedundantConnection();
        System.out.println(Arrays.toString(redundantConnection.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
    }

    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length + 1);
        for (int[] edge : edges) {
            if (uf.union(edge[0], edge[1])) return edge;
        }
        return null;
    }

    private class UF {
        private int[] id;


        public UF(int count) {
            this.id = new int[count];
            for (int i = 0; i < id.length; i++) {
                id[i] = i;
            }
        }

        private boolean union(int a, int b) {
            int i = find(a);
            int j = find(b);
            if (i == j) return true;
            id[i] = j;
            return false;
        }

        private int find(int a) {
            return a == id[a] ? a : (id[a] = find(id[a]));
        }
    }
}
