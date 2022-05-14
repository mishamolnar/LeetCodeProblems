package LeetCode.arrays;


//https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(new int[]{1, 3}, 0));
    }

    private int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (right > left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return nums[left] >= target ? left : ++left;
    }
}
