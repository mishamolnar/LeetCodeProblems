package LeetCode.binarySearch;

//https://leetcode.com/problems/find-peak-element/
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPeak(nums, left)) return left;
            if (isPeak(nums, right)) return right;
            if (isPeak(nums, mid)) return mid;
            if (mid > 0 && nums[mid] > nums[mid - 1]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }


    private boolean isPeak(int[] nums, int i) {
        long left = i > 0 ? nums[i - 1] : Long.MIN_VALUE;
        long right = i < nums.length - 1 ? nums[i + 1] : Long.MIN_VALUE;
        return nums[i] > left && nums[i] > right;
    }
}
