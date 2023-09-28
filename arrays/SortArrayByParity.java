package LeetCode.arrays;

import java.util.Arrays;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (right - left > 0) {
            while (left < right && nums[left] % 2 == 0)
                left++;
            while (right > left && nums[right] % 2 == 1)
                right--;
            swap(nums, left++, right--);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int buff = nums[i];
        nums[i] = nums[j];
        nums[j] = buff;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortArrayByParity().sortArrayByParity(new int[]{3, 1, 2, 4})));
    }
}
