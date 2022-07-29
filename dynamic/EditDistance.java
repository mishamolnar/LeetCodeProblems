package LeetCode.dynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

//https://leetcode.com/problems/edit-distance/submissions/
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+ 1][word2.length() + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, 10000);
        }

        dp[0][0] = 0;

        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = 0; j < dp[i].length - 1; j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j];
                else {
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + 1);
                }
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            res = Math.min(res, dp[dp.length - 1][i] + (dp[0].length - 1 - i));
        }

        for (int i = 0; i < dp.length; i++) {
            res = Math.min(res, dp[i][dp[0].length - 1] + (dp.length - 1 - i));
        }

        return res;
    }


    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance("intention", "execution"));
    }
}
