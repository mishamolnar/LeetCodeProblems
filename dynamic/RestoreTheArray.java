package LeetCode.dynamic;

public class RestoreTheArray {
    public int numberOfArrays(String s, int k) {
        int MOD = 1_000_000_007;
        int len = s.length(), kLen = String.valueOf(k).length();
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0 && kLen >= i - j && Long.parseLong(s.substring(j, i + 1)) <= k; j--) {
                if (s.charAt(j) == '0')
                    continue;
                dp[i] += j > 0 ? dp[j - 1]: 1;
                dp[i] %= MOD;
            }
        }
        return dp[len - 1];
    }
}
