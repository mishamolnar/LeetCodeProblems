package LeetCode.arrays;

//https://leetcode.com/problems/sort-colors/
public class SortColors {
    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        sortColors.sortColors(new int[]{2,0,1});
    }

    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i < nums.length;) {
            if (i == right) break;
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                exch(nums, left, i);
                i++;
                left++;
            } else if (nums[i] == 2) {
                exch(nums, right, i);
                right--;
            }
        }
    }

    private void exch(int[] nums, int a, int b) {
        int buff = nums[a];
        nums[a] = nums[b];
        nums[b] = buff;
    }
}
