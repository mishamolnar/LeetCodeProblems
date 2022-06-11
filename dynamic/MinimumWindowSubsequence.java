package LeetCode.dynamic;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-window-subsequence/submissions/
public class MinimumWindowSubsequence {

    // O(mn) space and time
    public String minWindow(String s1, String s2) {
        int[][] dp = new int[s2.length()][s1.length()];
        int start = 0, end = 0, length = Integer.MAX_VALUE;
        for (int[] ints : dp) Arrays.fill(ints, Integer.MAX_VALUE);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (s2.charAt(i) == s1.charAt(j)) {
                    if (i == 0) dp[i][j] = j;
                    else if (j > 0) dp[i][j] = dp[i - 1][j - 1];
                } else if (j > 0) dp[i][j] = dp[i][j - 1];
                if (i == s2.length() - 1 && dp[i][j] != Integer.MAX_VALUE && j - dp[i][j] + 1 < length) {
                    start = dp[i][j];
                    end = j + 1;
                    length = j - dp[i][j] + 1;
                }
            }
        }
        return s1.substring(start, end);
    }


    public static void main(String[] args) {
        MinimumWindowSubsequence minimumWindowSubsequence = new MinimumWindowSubsequence();
        System.out.println(minimumWindowSubsequence.minWindow("abcdebdde", "bde"));
    }
}
