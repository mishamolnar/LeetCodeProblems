package LeetCode.arrays;

//https://leetcode.com/problems/sort-colors/
public class SortColors {
    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        sortColors.sortColors(new int[]{2,1,2});
    }

    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, curr = 0;
        while (curr <= right) {
            if (nums[curr] == 0) {
                swap(nums, curr, left);
                left++;
                curr++;
            } else if (nums[curr] == 1) {
                curr++;
            } else {
                swap(nums, right, curr);
                right--;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int buff = nums[left];
        nums[left] = nums[right];
        nums[right] = buff;
    }
}
