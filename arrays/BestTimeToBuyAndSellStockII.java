package LeetCode.arrays;

//link - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/
public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII bestTimeToBuyAndSellStockII = new BestTimeToBuyAndSellStockII();
        System.out.println(bestTimeToBuyAndSellStockII.maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, res = 0;
        for (int price : prices) {
            if (price > min) {
                res += price - min;
            }
            min = price;
        }
        return res;
    }
}
