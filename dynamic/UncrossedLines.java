package LeetCode.dynamic;

import java.util.Arrays;

public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i- 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }

    public int maxUncrossedLinesOptimized(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, res = 0;
        int[] dp = new int[Math.min(len1, len2) + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = -1;
        for (int candidate : nums1) {
            int curr = res;
            for (int j = len2 - 1; j >= 0; j--) {
                while (j <= dp[curr]) {
                    curr--;
                }
                if (j > dp[curr] && candidate == nums2[j]) {
                    dp[curr + 1] = Math.min(dp[curr + 1], j);
                    res = Math.max(res, curr + 1);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new UncrossedLines().maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
    }
}
