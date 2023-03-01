package LeetCode.binarySearch;

public class WaysToSplitIntoThreeSubarrays {

    public int waysToSplit(int[] nums) {
        //first division [i] (between first and second part) is done in the cycle
        //then we need to find the start and the end of the possible second division
        //the start of the second division is when
        // prefix[start] - prefix[i] >= prefix[i] && prefix[last] - prefix[start] >= prefix[start] - prefix[i]
        //the end of the second division is the last element where this condition is true
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int firstValid = firstValid(nums, i);
            if (firstValid == -1) break;
            int lastValid = lastValid(nums, i, firstValid);
            if (lastValid == -1) break;
            res += (lastValid - firstValid + 1);
            res %= 1_000_000_007;
        }
        return res;
    }

    private int lastValid(int[] nums, int start, int firstMiddle) {
        int left = firstMiddle, right = nums.length - 1;
        while (right - left > 1) {
            int middle = left + (right - left) / 2;
            if (testLastValid(nums, start, middle)) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return testLastValid(nums, start,left) ? left : -1;
    }

    private boolean testLastValid(int[] nums, int start, int middle) {
        return nums[nums.length - 1] - nums[middle] >= nums[middle] - nums[start];
    }

    private int firstValid(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (right - left > 1) {
            int middle = left + (right - left) / 2;
            if (testFirstValid(nums, start, middle)) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return testFirstValid(nums, start, right) ? right : -1;
    }

    private boolean testFirstValid(int[] nums, int start, int middle) {
        return nums[middle] - nums[start] >= nums[start];
    }
}
