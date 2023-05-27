package LeetCode.dynamic;

import java.util.Arrays;

public class SnoteGameIII {

    //naive recursion approach with memoization,
    //array [2][len]
    public String stoneGameIIITD(int[] stoneValue) {
        int sum = Arrays.stream(stoneValue).sum();
        int[][] memo = new int[2][stoneValue.length];
        Arrays.fill(memo[0], -1);
        Arrays.fill(memo[1], -1);
        int alice = stoneGameIII(0, 0, stoneValue, memo);
        int bob = sum - alice;
        return bob > alice ? "Bob" : bob == alice ? "Tie" : "Alice";
    }

    //returns the Alice's score in this index, if player places
    //top down
    private int stoneGameIII(int index, int player, int[] stoneValue, int[][] memo) {
        if (index == stoneValue.length)
            return 0;
        if (memo[player][index] != -1)
            return memo[player][index];
        int res = player == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE, currentStones = 0;
        for (int i = index; i < Math.min(stoneValue.length, index + 3); i++) {
            if (player == 0) {
                currentStones += stoneValue[i];
                res = Math.max(stoneGameIII(i + 1, 1, stoneValue, memo) + currentStones, res);
            } else {
                res = Math.min(stoneGameIII(i + 1, 0, stoneValue, memo), res);
            }
        }
        memo[player][index] = res;
        return res;
    }

    //bottom up
    //bob line    dp[1][i] - math.min(dp[0][i + 1], dp[0][i + 2], dp[0][i + 3]
    //alice line  dp[0][i] - math.max(sum[i-i] + dp[1][i + 1] ...)
    public String stoneGameIII(int[] stoneValue) {
        int len = stoneValue.length;
        int[][] dp = new int[2][len ];
        for (int i = len - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j <= Math.min(len, i + 3); j++) {
                min = Math.min(min, j < len ? dp[0][j] : 0);
            }
            dp[1][i] = min;
            int max = Integer.MIN_VALUE, sum = 0;
            for (int j = i; j < Math.min(len, i + 3); j++) {
                sum += stoneValue[j];
                max = Math.max(max, sum + (j + 1 < len ? dp[1][j + 1] : 0));
            }
            dp[0][i] = max;
        }
        int alice = dp[0][0], sum = Arrays.stream(stoneValue).sum();
        int bob = sum - alice;
        return bob > alice ? "Bob" : bob == alice ? "Tie" : "Alice";
    }


    public static void main(String[] args) {
        System.out.println(new SnoteGameIII().stoneGameIII(new int[]{1,2,3,7}));
    }
}
