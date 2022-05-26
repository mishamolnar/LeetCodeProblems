package LeetCode.dynamic;

// link - https://leetcode.com/problems/longest-common-subsequence/submissions/
// time complexity O(nm) and time complexity O(nm)
public class LongestCommonSubsequence {

    public int longestCommonSubsequenceTwo(String text1, String text2) {
        int[][] arr = new int[text2.length() + 1][text1.length() + 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = arr[0].length - 2; j >= 0; j--) {
                if (text2.charAt(i) == text1.charAt(j)) {
                    arr[i][j] = 1 + arr[i + 1][j + 1];
                } else {
                    arr[i][j] = Math.max(arr[i + 1][j], arr[j][i + 1]);
                }
            }
        }
        return arr[0][0];
    }



    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.longestCommonSubsequence("ace", "abcde"));
    }
}
