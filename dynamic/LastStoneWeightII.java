package LeetCode.dynamic;

import java.util.Arrays;

//https://leetcode.com/problems/last-stone-weight-ii/discuss/295167/Java-beat-100-with-nice-explanation
public class LastStoneWeightII {
    private int result = Integer.MAX_VALUE;

    public int lastStoneWeightII(int[] stones) {
        boolean[] dp = new boolean[1501];
        int sum = 0;
        dp[0] = true;
        for (int stone : stones) {
            sum += stone;
            for (int i = Math.min(sum, 1500); i >= stone; i--) {
                dp[i] |= dp[i - stone];
            }
        }
        for (int i = sum / 2; i >= 0; i--) {
            if (dp[i]) return sum - i - i;
        }
        return 0;
    }

    public static void main(String[] args) {
        LastStoneWeightII lastStoneWeightII = new LastStoneWeightII();
        System.out.println(lastStoneWeightII.lastStoneWeightII(new int[]{31,26,33,21,40}));
    }
}
