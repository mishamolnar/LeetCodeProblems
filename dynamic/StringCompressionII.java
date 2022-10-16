package LeetCode.dynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

//https://leetcode.com/problems/string-compression-ii/solutions/
public class StringCompressionII {

    public int getLengthOfOptimalCompression(String s, int k) {
        int[][] dp = new int[s.length() + 1][k + 1];

        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        Arrays.fill(dp[0], 0);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= k; j++) {
                if (j > 0)
                    dp[i][j] = dp[i - 1][j - 1];
                int sequence = 0, removed = 0;
                for (int l = i; l > 0; l--) {
                    if (s.charAt(i - 1) == s.charAt(l - 1))
                        sequence++;
                    else if (++removed > j) break;
                    dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - removed] + calLen(sequence));
                }
            }
        }
        return dp[s.length()][k];
    }

    private int calLen(int len) {
        if (len == 0) return 0;
        else if (len == 1) return 1;
        else if (len < 10) return 2;
        else if (len < 100) return 3;
        else return 4;
    }
}
