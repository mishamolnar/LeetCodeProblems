package LeetCode.dynamic;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-vacation-days/
public class MaximumVacationDays {

    //O(n^2m) - nm to feel the matrix and o(n) to get the path
    public int maxVacationDays(int[][] flights, int[][] days) {
        int[][] memo = new int[flights.length][days[0].length]; //для запамятовування результату в конкретний тиждень в конкретний день
        for (int[] l: memo)
            Arrays.fill(l, Integer.MIN_VALUE);
        return dfs(flights, days, memo, 0, 0);
    }

    private int dfs(int[][] flights, int[][] days, int[][] memo, int city, int currentWeek) {
        if (currentWeek == days.length) return 0;
        if (memo[city][currentWeek] != Integer.MIN_VALUE) return memo[city][currentWeek];
        int maxVac = 0, vac = 0;
        for (int i = 0; i < flights.length; i++) {
            if (flights[city][i] == 1 || i == city) {
                vac = days[city][currentWeek] + dfs(flights, days, memo, i, currentWeek + 1);
                maxVac = Math.max(maxVac, vac);
            }
        }
        memo[city][currentWeek] = maxVac;
        return maxVac;
    }
}
