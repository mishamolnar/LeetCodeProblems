package LeetCode.dynamic;

public class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons {
    public int numOfArrays(int n, int m, int k) {
        long[][][] dp = new long[n + 1][m + 1][k + 1];
        int MOD = 1_000_000_007;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int l = 1; l <= k; l++) {
                    if (i == 1) dp[i][j][l] = 1;
                    dp[i + 1][j][l] += (dp[i][j][l] * j % MOD);
                    if (l < k) {
                        for (int newMax = j + 1; newMax <= m; newMax++) {
                            dp[i + 1][newMax][k + 1] += dp[i][j][l];
                            dp[i + 1][newMax][k + 1] %= MOD;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= m; i++) {
            res += dp[n][i][k];
            res %= MOD;
        }
        return res;
    }
}
