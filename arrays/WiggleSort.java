package LeetCode.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/wiggle-sort/submissions/
public class WiggleSort {
    public static void main(String[] args) {

    }

    public void wiggleSort(int[] nums) {
        if (nums.length < 3) {
            Arrays.sort(nums);
            return;
        }
        if (nums[0] > nums[1]) swap(nums, 0 ,1);
        if (nums[2] > nums[1]) swap(nums, 1, 2);
        for (int i = 3; i < nums.length - 1; i = i + 2) {
            if (nums[i] < nums[i - 1]) swap(nums, i, i - 1);
            if (nums[i] < nums[i + 1]) swap(nums, i, i + 1);
        }
        if (nums.length % 2 == 0 && nums[nums.length - 1] < nums[nums.length - 2]) swap(nums, nums.length - 1, nums.length - 2);
        if (nums.length % 2 == 1 && nums[nums.length - 2] < nums[nums.length - 1]) swap(nums, nums.length - 1, nums.length - 2);
    }

    private void swap(int[] nums, int i, int j) {
        int buff = nums[i];
        nums[i] = nums[j];
        nums[j] = buff;
    }
}
