package LeetCode.arrays;

//time - O(n)
//space - O(1)
// link - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BuyAnsSellStock {
    public int maxProfit(int[] prices) {
        int currentMin = prices[0];
        int profit = 0;
        if (prices.length == 1) return 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - currentMin > profit) {
                profit = prices[i] - currentMin;
            } else if (prices[i] < currentMin) {
                currentMin = prices[i];
            }
        }
        return profit;
    }
}
