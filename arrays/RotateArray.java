package LeetCode.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/rotate-array/
public class RotateArray {
    public void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int buff = nums[start];
            nums[start] = nums[end];
            nums[end] = buff;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] arr = new int[]{1, 2, 3, 4};
        rotateArray.rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}
