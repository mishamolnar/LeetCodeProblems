package LeetCode.dynamic;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfIncreasingPasses {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int countPaths(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = 1;
                pq.add(new int[]{grid[i][j], i, j});
            }
        }
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            for (int[] dir : DIRECTIONS) {
                int i = curr[1] + dir[0];
                int j = curr[2] + dir[1];
                if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] > grid[curr[1]][curr[2]]) {
                    dp[i][j] += dp[curr[1]][curr[2]];
                    dp[i][j] %= 1_000_000_007;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += dp[i][j];
                sum %= 1_000_000_007;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        NumberOfIncreasingPasses numberOfIncreasingPasses = new NumberOfIncreasingPasses();
        System.out.println(numberOfIncreasingPasses.countPaths(new int[][]{{1, 1},{3, 4}}));
    }
}
