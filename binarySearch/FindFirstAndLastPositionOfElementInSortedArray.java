package LeetCode.binarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray ffal = new FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(ffal.searchRange(new int[]{5, 6, 7, 7, 8, 8, 8, 8, 8, 10}, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirstIndex(nums, target), findLastIndex(nums, target)};
    }

    private int findLastIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target)) return mid;
            if (nums[mid] > target) right = mid - 1;
            else  left = mid + 1;
        }
        return -1;
    }

    private int findFirstIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target && (mid == 0 || nums[mid - 1] != target)) return mid;
            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
