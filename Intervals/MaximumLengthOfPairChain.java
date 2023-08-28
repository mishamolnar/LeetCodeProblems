package LeetCode.Intervals;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        //sort by start then by end
        //maintain treemap with end -> count of chain
        Arrays.sort(pairs, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        int[] dp = new int[2002];
        for (int[] pair : pairs) {
            int count = pair[0] + 1001 - 1;
            fill(dp, pair[1] + 1, count + 1);
        }
        return dp[2001];
    }

    private void fill(int[] dp, int start, int value) {
        for (int i = start; i < dp.length; i++) {
            if (dp[i] < value) {
                dp[i] = value;
            } else break;
        }
    }
}
