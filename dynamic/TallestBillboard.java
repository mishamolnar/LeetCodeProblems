package LeetCode.dynamic;

import java.util.Arrays;

public class TallestBillboard {

    //Let n be the length of the input array rods and m be the maximum sum of rods.
    // complexity n * m * m
    public int tallestBillboardSlow(int[] rods) {
        //brute force - backtracking, 2^n and then return longest with equal size
        //each time we have a choice - add to left, to right or not to add at all
        int sum = Arrays.stream(rods).sum(), ans = 0, len = rods.length;
        int[][] dp = new int[sum][sum];
        for (int[] ints : dp)
            Arrays.fill(ints, Integer.MAX_VALUE);
        dp[0][0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j] != Integer.MAX_VALUE) {
                    for (int k = dp[i][j]; k < len; k++) {
                        dp[i + rods[k]][j] = Math.min(k + 1, dp[i + rods[k]][j]);
                        dp[i][j + rods[k]] = Math.min(k + 1, dp[i][j + rods[k]]);
                    }
                    if (i == j)
                        ans = Math.max(i, ans);
                }
            }
        }
        return ans;
    }


    //to do: with complexity n * m
    public int tallestBillboard(int[] rods) {
        return 0;
    }
}
