package LeetCode.arrays;

public class LongestSubarrayOf1 {
    public int longestSubarray(int[] nums) {
        int[] prefix = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix[i] = count;
            count = nums[i] == 0 ? 0 : count + nums[i];
        }
        int[] suffix = new int[nums.length];
        count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            suffix[i] = count;
            count = nums[i] == 0 ? 0 : count + nums[i];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                res = Math.max(suffix[i] + prefix[i], res);
            }
        }
        return res;
    }
}
