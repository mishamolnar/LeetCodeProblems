package LeetCode.arrays;

public class MinimumReplacementsToSortArray {
    public long minimumReplacement(int[] nums) {
        int min = nums[nums.length - 1];
        long res = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > min) {
                long numParts = calculateReplacement(nums[i], min);
                res += numParts - 1;
                min = nums[i] / (int)numParts;
            }
            min = Math.min(nums[i], min);
        }
        return res;
    }

    private long calculateReplacement(int bigger, int smaller) {
        return ((long) (bigger + smaller  - 1) / smaller);
    }
}
