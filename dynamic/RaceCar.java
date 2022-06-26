package LeetCode.dynamic;

import java.util.*;

public class RaceCar {

    //BFS n log n complexity
    // n distinct positions and log n distinct speeds, we are memorizing speed and position
    public int racecar(int target) {

        //do it 27.06
        return 0;
    }

    public int racecarDP(int target) {
        int[] dp = new int[target + 1];

        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;

            int m = 1, j = 1;

            for (; j < i; j = (1 << ++m) - 1) {
                for (int q = 0, p = 0; p < j; p = (1 << ++q) - 1) {
                    dp[i] = Math.min(dp[i], m + 1 + q + 1 + dp[i - (j - p)]);
                    //m is the number of A before the first R, q is the number of A before the second R
                }
            }

            dp[i] = Math.min(dp[i], m + (i == j ? 0 : 1 + dp[j - i]));
        }

        return dp[target];
    }

    public static void main(String[] args) {
        RaceCar raceCar = new RaceCar();
        System.out.println(raceCar.racecar(4));
    }
}
