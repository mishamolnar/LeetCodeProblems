package LeetCode.dynamic;

public class NumberOfMusicPlaylists {
    private static final int MOD = 1_000_000_007;
    public int numMusicPlaylists(int n, int goal, int k) {
        long[][] dp = new long[goal + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= n && j <= i; j++) {
                dp[i][j] = Math.max(j - k, 0) * dp[i - 1][j] + (n - j + 1) * dp[i - 1][j - 1];
                dp[i][j] %= MOD;
            }
        }
        return (int) dp[goal][n];
    }
}
