package LeetCode.binarySearch;

import java.util.Arrays;

public class MinimumCostToMakeArrayEqual {



    //binary search
    public long minCost(int[] nums, int[] cost) {
        int left = Arrays.stream(nums).min().getAsInt(), right = Arrays.stream(nums).max().getAsInt();
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (calculate(nums, cost, mid + 1) < calculate(nums, cost, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(calculate(nums, cost, left), calculate(nums, cost, right));
    }

    private long calculate(int[] nums, int[] cost, int target) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += (long) (Math.abs(target - nums[i])) * cost[i];
        }
        return res;
    }
}
