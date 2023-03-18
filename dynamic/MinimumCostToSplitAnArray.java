package LeetCode.dynamic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumCostToSplitAnArray {
    public int minCost(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = k;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            Map<Integer, Integer> unique = new HashMap<>();
            int uniqueCounter = 0;
            for (int j = i; j >= 0; j--) { //j - first element in new split
                if (!unique.containsKey(nums[j])) {
                    uniqueCounter++;
                } else if (unique.get(nums[j]) == 1) {
                    uniqueCounter--;
                }
                unique.put(nums[j], unique.getOrDefault(nums[j], 0) + 1);
                dp[i] = Math.min(dp[i], (j > 0 ? dp[j - 1] : 0) + k + (i - j + 1 - uniqueCounter));
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumCostToSplitAnArray().minCost(new int[]{1,2,1,2,1}, 5));
    }
}
