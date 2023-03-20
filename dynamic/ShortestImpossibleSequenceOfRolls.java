package LeetCode.dynamic;

import java.util.Arrays;

public class ShortestImpossibleSequenceOfRolls {
    public int shortestSequence(int[] rolls, int k) {
        int[] dp = new int[k + 1];
        int ans = 1, count = 0;
        for (int roll : rolls) {
            dp[roll]++;
            if (dp[roll] == 1) count++;
            if (count == k) {
                ans++;
                Arrays.fill(dp, 0);
            }
        }
        return ans;
    }
}
