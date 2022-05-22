package LeetCode.dynamic;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-path-sum/submissions/
public class MinimumPathSum {
    public int minPathSumRecursiveNaive(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] ints : dp) Arrays.fill(ints, -1);
        return helper(grid, 0, 0, 0, dp);
    }

    private int helper(int[][] grid, int x, int y, int currentSum, int[][] dp) {
        if (x >= grid.length || y >= grid[0].length) return Integer.MAX_VALUE;
        if (dp[x][y] != -1) return dp[x][y];
        if (x == grid.length - 1 && y == grid[0].length - 1) return grid[x][y] + currentSum;
        dp[x][y] = grid[x][y] + Math.min(helper(grid, x + 1, y, currentSum, dp), helper(grid, x, y + 1, currentSum, dp));
        return dp[x][y];
    }

    //iterative
    public int minPathSum(int[][] grid) {
        int height = grid.length - 1, len = grid[0].length - 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] = grid[i][j] + grid[i][j - 1];
                else if (j == 0) grid[i][j] = grid[i][j] + grid[i - 1][j];
                else grid[i][j] = grid[i][j] + Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[height][len];
    }
}
