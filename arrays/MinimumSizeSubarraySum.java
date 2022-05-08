package LeetCode.arrays;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(4, new int[]{2,3,1,2,4,3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, currentSum = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            while (currentSum >= target) {
                result = Math.min(i - left + 1, result);
                currentSum -= nums[left];
                left++;
            }

        }
        return result < Integer.MAX_VALUE ? result : 0;
    }
}
