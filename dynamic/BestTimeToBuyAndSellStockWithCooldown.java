package LeetCode.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown bestTimeToBuyAndSellStockWithCooldown = new BestTimeToBuyAndSellStockWithCooldown();
        System.out.println(bestTimeToBuyAndSellStockWithCooldown.maxProfit(new int[]{1,2,3,0,2}));
    }

    public int maxProfitIterative(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] s0 = new int[prices.length];
        int[] s1 = new int[prices.length];
        int[] s2 = new int[prices.length];
        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
            s2[i] = s1[i - 1] + prices[i];
        }
        return Math.max(s0[s0.length - 1], s2[s0.length - 1]);
    }

    public int maxProfit(int[] prices) {
        return helper(0, true, prices, new HashMap<>());
    }

    private int helper(int index, boolean buying, int[] prices, Map<Map.Entry<Integer, Boolean>, Integer> dp) {
        if (index >= prices.length) return 0;
        else if (dp.containsKey(Map.entry(index, buying))) return dp.get(Map.entry(index, buying));
        else if (buying) {
            int buyNow = helper(index + 1, false, prices, dp) - prices[index];
            int cooldown = helper(index + 1, true, prices, dp);
            dp.put(Map.entry(index, true), Math.max(buyNow, cooldown));
            return Math.max(buyNow, cooldown);
        } else {
            int sellNow = helper(index + 2, true, prices, dp) + prices[index];
            int cooldown = helper(index + 1, false, prices, dp);
            dp.put(Map.entry(index, false), Math.max(sellNow, cooldown));
            return Math.max(sellNow, cooldown);
        }
    }
}
