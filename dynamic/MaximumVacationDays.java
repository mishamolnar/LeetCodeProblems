package LeetCode.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/maximum-vacation-days/
public class MaximumVacationDays {

    //O(n^2m) - nm to feel the matrix and o(n) to get the path
    public int maxVacationDays(int[][] flights, int[][] days) {
        int[][] memo = new int[flights.length][days[0].length];
        for (int[] l: memo)
            Arrays.fill(l, Integer.MIN_VALUE);
        return dfs(flights, days, 0, 0, memo);
    }

    public int dfs(int[][] flights, int[][] days, int cur_city, int weekno, int[][] memo) {
        if (weekno == days[0].length)
            return 0;
        if (memo[cur_city][weekno] != Integer.MIN_VALUE)
            return memo[cur_city][weekno];
        int maxvac = 0;
        for (int i = 0; i < flights.length; i++) {
            if (flights[cur_city][i] == 1 || i == cur_city) {
                int vac = days[i][weekno] + dfs(flights, days, i, weekno + 1, memo);
                maxvac = Math.max(maxvac, vac);
            }
        }
        memo[cur_city][weekno] = maxvac;
        return maxvac;
    }


    public static void main(String[] args) {
        MaximumVacationDays maximumVacationDays = new MaximumVacationDays();
        System.out.println(maximumVacationDays.maxVacationDays(new int[][]{{0,1,1},{1,0,1},{1,1,0}}, new int[][]{{1,3,1},{6,0,3},{3,3,3}}));
    }
}
