package LeetCode.dynamic;

import java.util.Arrays;

public class StoneGameII {


    //no difference between alice and bob, alice just starts at index 0
    //all state is just index + M
    //dp[index][m] = Math.max(dp[index + 2 ... index + 2m][1 ... m]
    //when we set m 1 then we need to have max between
    // score[index] + (prefixsum[index + 1] - dp[index + 1][1])
    //and
    // score[index] + score[index + 1] + (prefixsum[index + 2] - dp[index + 2][2])
    //when m > 1, then we do the same thing, but up to m
    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[2][piles.length + 1][piles.length + 1];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        return stoneGameII(0, 0, 1, dp, piles);
    }

    //bob min, alice max
    private int stoneGameII(int user, int index, int m, int[][][] memo, int[] piles) {
        if (index == piles.length) {
            return 0;
        }
        if (memo[user][index][m] != -1) {
            return memo[user][index][m];
        }
        int res = user == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE, s = 0;
        for (int count = 1; count <= Math.min(2 * m, piles.length - index); count++) {
            s += piles[index + count - 1];
            if (user == 0) { //alice
                res = Math.max(res, s + stoneGameII(1, index + count, Math.max(count, m), memo, piles));
            } else { //bob
                res = Math.min(res, stoneGameII(0, index + count, Math.max(count, m), memo, piles));
            }
        }
        memo[user][index][m] = res;
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new StoneGameII().stoneGameII(new int[]{2,7,9,4,4}));
        System.out.println(new StoneGameII().stoneGameII(new int[]{1,2,3,4,5,100}));
    }

    //1   2   3   4   5   100
    //126 125 112 109 105 100



    //    26 24 17 8  4 - reverseSum
    //    2  7  9  4  4 - piles
    //1   10 16 13 8  4
    //2      24 17 8  4
    //3      24 17 8  4
    //4      24 17 8  4
    //5      24 17 8  4
}
