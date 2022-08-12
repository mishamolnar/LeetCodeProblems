package LeetCode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//BFS OR DP
//https://leetcode.com/problems/perfect-squares/
public class PerfectSquares {
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (int sq : squares) {
                if (sq + i > n) continue;
                dp[i + sq] = Math.min(dp[i] + 1, dp[i + sq]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        System.out.println(perfectSquares.numSquares(1));
    }
}
