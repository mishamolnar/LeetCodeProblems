package LeetCode.dynamic;

public class MaxDotProductOfTwoSubsequences {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                dp[i][j] = Math.max(
                        Math.max(
                                i > 0 ? dp[i - 1][j] : Integer.MIN_VALUE,
                                j > 0 ? dp[i][j - 1] : Integer.MIN_VALUE),
                        nums1[i] * nums2[j] + (i > 0 && j > 0 ? dp[i - 1][j - 1] : 0)
                );
            }
        }
        return dp[nums1.length - 1][nums2.length - 1];
    }
}
