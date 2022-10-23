package LeetCode.graph;

import java.util.Arrays;

//https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
public class CityWithSmallestNumberOfNeibours {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] bf = new int[n][n];
        for (int[] ints : bf) Arrays.fill(ints, 1001);
        for (int[] edge : edges) {
            bf[edge[0]][edge[1]] = edge[2];
            bf[edge[1]][edge[0]] = edge[2];
        }
        for (int i = 0; i < n; i++)
            bf[i][i] = 0;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    bf[i][j] = Math.min(bf[i][j], bf[i][k] + bf[k][j]);
                }
            }
        }
        int res = 0, min = 102;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (bf[i][j] <= distanceThreshold) count++;
            }
            if (count <= min)
                res = i;
            min = Math.min(min, count);
        }
        return res;
    }

    public static void main(String[] args) {
        CityWithSmallestNumberOfNeibours city = new CityWithSmallestNumberOfNeibours();
        System.out.println(city.findTheCity(5, new int[][]{{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}}, 4));
    }
}
