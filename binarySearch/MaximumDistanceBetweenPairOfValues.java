package LeetCode.binarySearch;


//https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/submissions/
public class MaximumDistanceBetweenPairOfValues {
    public static void main(String[] args) {
        MaximumDistanceBetweenPairOfValues maximumDistanceBetweenPairOfValues = new MaximumDistanceBetweenPairOfValues();
        System.out.println(maximumDistanceBetweenPairOfValues.binarySearch(new int[]{10, 10, 1}, 0, 2));
        System.out.println(maximumDistanceBetweenPairOfValues.maxDistance(new int[]{5,4}, new int[]{3,2}));
    }


    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDistance = 0;
        for (int i = 0; i < nums1.length; i++) {
            int dist = binarySearch(nums2, i, nums1[i]);
            if (dist != -1) {
                maxDistance = Math.max(maxDistance, dist - i);
            }
        }
        return maxDistance;
    }

    private int binarySearch(int[] nums, int left, int target) {
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) left = mid;
            else right = mid;
        }
        if (nums[right] >= target) return right;
        if (nums[left] >= target) return left;
        return -1;
    }
}
