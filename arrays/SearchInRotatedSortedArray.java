package LeetCode.arrays;

//link - https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {

    //time complexity - O(n)
    // space complexity - O(1)
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left]) { //left part is sorted
                if (target <= nums[mid] && target >= nums[left]) { //left part contains answer
                    right = mid;
                } else left = mid + 1; //if no - then right part
            } else { //right part is sorted
                if (target >= nums[mid] && target <= nums[right]) { //right part contains answer;
                    left = mid;
                } else right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
