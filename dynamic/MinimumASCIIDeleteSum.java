package LeetCode.dynamic;

import java.util.Arrays;

public class MinimumASCIIDeleteSum {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i < s1.length() && j < s2.length()) {
                    char one = s1.charAt(i);
                    char two = s2.charAt(j);
                    if (one == two) {
                        dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j]);
                    }
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + one);
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + two);
                } else if (i == s1.length() && j < s2.length()) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + s2.charAt(j));
                } else if (i < s1.length()) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + s1.charAt(i));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }



    public static void main(String[] args) {
        new MinimumASCIIDeleteSum().minimumDeleteSum("sea", "eat");
    }
}
