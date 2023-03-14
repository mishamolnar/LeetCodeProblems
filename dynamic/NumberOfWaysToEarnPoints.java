package LeetCode.dynamic;

import java.util.Arrays;

public class NumberOfWaysToEarnPoints {
    public int waysToReachTarget(int target, int[][] types) {
        int[][] dp = new int[types.length + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int count = 0; count <= types[i - 1][0] && count * types[i - 1][1] <= j; count++) {
                    dp[i][j] += dp[i - 1][j - count * types[i - 1][1]];
                }
            }
        }
        return dp[types.length][target];
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfWaysToEarnPoints().waysToReachTarget(6, new int[][]{{6, 1}, {3, 2}, {2, 3}}));
    }
}
