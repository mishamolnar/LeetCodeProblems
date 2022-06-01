package LeetCode.arrays;

//https://leetcode.com/problems/missing-element-in-sorted-array/
public class MissingElementInSortedArray {

    //log (n) solution and constant space
    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums[nums.length - 1] - nums[0] - (nums.length - 1);
        if (k > right) return nums[nums.length - 1] + (k - right);
        while (left <= right) {
            int mid = left + (right - left) / 2 < nums.length ? left + (right - left) / 2 : nums.length - 1;
            int missing = nums[mid] - nums[0] - mid;
            if (missing >= k) right = mid - 1;
            else left = mid + 1;
        }
        return nums[right] + k - (nums[right] - nums[0] - right);
    }

    public static void main(String[] args) {
        MissingElementInSortedArray element = new MissingElementInSortedArray();
        System.out.println(element.missingElement(new int[]{746421,1033196,1647541,4775111,7769817,8030384}, 10));
    }
}
