package LeetCode.arrays;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) nums[i] += nums[i - 1];
            res += map.getOrDefault(nums[i] - k, 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK sum = new SubarraySumEqualsK();
        System.out.println(sum.subarraySum(new int[]{1, 2, 3}, 3));
    }
}
