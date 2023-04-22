package LeetCode.dynamic;

import java.util.Arrays;

public class MinimumInsertionStepsToMakeStringPalindrome {
    public int minInsertions(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        dp[len - 1][0] = 0;
        int min = Integer.MAX_VALUE;
        for (int i = dp.length - 1; i >= 0; i--) {//i - end
            for (int j = 0; j <= i; j++) { //j - start
                if (i > 0) {
                    dp[i - 1][j] = Math.min(dp[i - 1][j], dp[i][j] + 1); //skipping end
                }
                if (j < len - 1) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);//skipping start
                }
                if (s.charAt(i) == s.charAt(j) && i > 0 && j < len - 1) {
                    dp[i - 1][j + 1] = Math.min(dp[i - 1][j + 1], dp[i][j]); //same, we can go +1 in both directions
                }
                if (Math.abs(i - j) < 1 || (Math.abs(i - j) == 1 && s.charAt(i) == s.charAt(j))) {
                    min = Math.min(min, dp[i][j]);
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumInsertionStepsToMakeStringPalindrome min = new MinimumInsertionStepsToMakeStringPalindrome();
        System.out.println(min.minInsertions("zjveiiwvc"));
    }
}
