package LeetCode.dynamic;

import java.util.Arrays;

public class MinimumPathCostGrid {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int[][] rows = new int[grid.length][grid[0].length];
        for (int[] row : rows) Arrays.fill(row, Integer.MAX_VALUE);
        rows[0] = grid[0];
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                for (int k = 0; k < grid[0].length; k++) {
                    rows[i + 1][k] = Math.min(rows[i + 1][k], rows[i][j] + grid[i + 1][k] + moveCost[grid[i][j]][k]);
                }
            }
        }
        return Arrays.stream(rows[rows.length - 1]).min().getAsInt();
    }

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0, iterations = minutesToTest / minutesToDie;
        while (Math.pow(iterations + 1, pigs) < buckets)
            pigs++;
        return pigs;
    }

    public static void main(String[] args) {
        System.out.println(15/15);
    }
}
