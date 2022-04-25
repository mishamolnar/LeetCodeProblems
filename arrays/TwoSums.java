package LeetCode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//complexity time - O(n), space complexity - same O(n)
// link https://leetcode.com/problems/two-sum/
public class TwoSums {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}
