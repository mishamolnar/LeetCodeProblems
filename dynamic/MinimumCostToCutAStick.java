package LeetCode.dynamic;

import java.util.Arrays;

public class MinimumCostToCutAStick {
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        Arrays.sort(cuts);
        int[][] dp = new int[len + 2][len + 2];
        for (int i = 2; i < len + 2; i++) {
            for (int j = i - 2; j >= 0; j--) {
                int start = j - 1 < 0 ? 0 : cuts[j - 1];
                int end = i - 1 >= cuts.length ? n : cuts[i - 1];
                int length = end - start;
                dp[j][i] = Integer.MAX_VALUE;
                for (int mid = j + 1; mid < i; mid++) {
                    dp[j][i] = Math.min(length + dp[j][mid] + dp[mid][i], dp[j][i]);
                }
            }
        }
        return dp[0][len + 1];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumCostToCutAStick().minCost(9, new int[]{5,6,1,4,2}));
    }
}
