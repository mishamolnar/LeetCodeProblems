package LeetCode.dynamic;

public class StrangePrinter {
    public int strangePrinter(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int length = 1; length <= len; length++) {
            for (int left = 0; left <= len - length; left++) {
                int right = left + length - 1, j = -1;
                dp[left][right] = Integer.MAX_VALUE;

                for (int mid = left; mid < right; mid++) {
                    if (s.charAt(mid) != s.charAt(right) && j == -1) {
                        j = mid;
                    }
                    if (j != -1) {
                        dp[left][right] = Math.min(dp[left][right], 1 + dp[j][mid] + dp[mid + 1][right]);
                    }
                }

                if (j == -1) {
                    dp[left][right] = 0;
                }
            }
        }
        return dp[0][len - 1] + 1;
    }
}
