package LeetCode.greedy;


//https://leetcode.com/problems/minimum-money-required-before-transactions/
public class MinimumMoneyRequiredBeforeTransactions {
    public long minimumMoney(int[][] transactions) {
        long sum = 0;
        for (int[] ints : transactions) {
            if (ints[0] > ints[1])
                sum += (ints[0] - ints[1]);
        }

        long res = 0;
        for (int[] ints : transactions) {
            if (ints[0] > ints[1]) {
                res = Math.max(res, sum + ints[1]);
            } else {
                res = Math.max(res, sum + ints[0]);
            }
        }
        return res;
    }
}
