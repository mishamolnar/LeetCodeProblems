package LeetCode.dynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

//https://leetcode.com/problems/number-of-ways-to-rearrange-sticks-with-k-sticks-visible/
public class NumberOfWaysToRearrangeSticksWithKSticksVisible {
    private static final int MODULO = (int) Math.pow(10, 9) + 7;

    public int rearrangeSticks(int n, int k) {
        int[][] memo = new int[n + 1][k + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }

        return helper(memo, n, k);
    }

    private int helper(int[][] memo, int n, int k) {
        if (k == 0 || n == 0) return 0;
        if (n == k) return 1;
        if (memo[n][k] != -1) return memo[n][k];

        long res = (long) (n - 1) * helper(memo, n - 1, k);
        res += helper(memo, n - 1, k - 1);
        res %= MODULO;

        memo[n][k] = (int) res;
        return (int) res;
    }


    public static void main(String[] args) {
        NumberOfWaysToRearrangeSticksWithKSticksVisible ways = new NumberOfWaysToRearrangeSticksWithKSticksVisible();
        System.out.println(ways.rearrangeSticks(20, 11));
        System.out.println(ways.rearrangeSticks(3, 2));
    }
}
