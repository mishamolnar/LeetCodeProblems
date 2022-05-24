package LeetCode.greedy;

import java.util.Arrays;

//https://leetcode.com/problems/two-city-scheduling/
public class TwoCityScheduling {
    public static void main(String[] args) {
        TwoCityScheduling cityScheduling = new TwoCityScheduling();
        System.out.println(cityScheduling.twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20}}));
    }

    // O(nlogn) time and constant space
    public int twoCitySchedCost(int[][] costs) {
        for (int[] cost : costs) cost[0] = cost[0] - cost[1];
        Arrays.sort(costs, (a, b) -> a[0] - b[0]);
        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) sum += costs[i][0] + costs[i][1];
            else sum += costs[i][1];
        }
        return sum;
    }
}
