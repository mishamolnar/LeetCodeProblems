package LeetCode.arrays;

import java.util.HashMap;

//https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/solution/
public class MaximumSizeSubarraySumEqualsK {

    public int maxSubArrayLen(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                max = Math.max(i - map.get(nums[i] - k), max);
            }
            map.putIfAbsent(nums[i], i);
        }
        return max;
    }
}
