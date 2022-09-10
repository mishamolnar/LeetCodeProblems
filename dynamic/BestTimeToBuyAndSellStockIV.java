package LeetCode.dynamic;

public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k][2];
        for (int[] ints : dp) {
            ints[0] = Integer.MIN_VALUE;
            ints[1] = Integer.MIN_VALUE;
        }
        for (int price : prices) {
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = Math.max(dp[i][0], (i == 0 ? 0 : dp[i - 1][1]) - price);
                dp[i][1] = Math.max(dp[i][1], dp[i][0] + price);
            }
        }
        int res = Integer.MIN_VALUE;
        for (int[] ints : dp) {
            res = Math.max(res, ints[1]);
        }
        return res;
    }
}
