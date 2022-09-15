package LeetCode.binarySearch;

//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums.length == 1) return nums[0] == target;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left ) / 2;
            if (nums[mid] == target
                    || nums[left] == target
                    || nums[right] == target)
                return true;
            if (nums[left] < nums[mid]) {
                if (nums[left] < target && nums[mid] > target) {
                    right = mid;
                } else left = mid + 1;
            } else if (nums[right] > nums[mid]) {
                if (nums[mid] < target && nums[right] > target) {
                    left = mid + 1;
                } else right = mid;
            } else {
                left++;
                right--;
            }
        }
        return false;
    }
}
