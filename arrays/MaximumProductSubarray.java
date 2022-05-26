package LeetCode.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/maximum-product-subarray/submissions/
public class MaximumProductSubarray {



    public int maxProductTwo(int[] nums) {
        int curr = 1, max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            curr *= nums[i];
            max = Math.max(nums[i], Math.max(max, curr));
            curr = curr == 0 ? 1 : curr;
        }
        curr = 1;
        int maxLeft = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            curr *= nums[i];
            maxLeft = Math.max(nums[i], Math.max(maxLeft, curr));
            curr = curr == 0 ? 1 : curr;
        }
        return Math.max(max, maxLeft);
    }

    // time - O(n)
    // space O(1)
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int right = 1;
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            right = right == 0 ? 1 : right;
            left = left == 0 ? 1 : left;

            right *= nums[i];
            left *= nums[nums.length - 1 - i];
            result = Math.max(result, Math.max(left, right));
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumSubarray = new MaximumProductSubarray();
        System.out.println(maximumSubarray.maxProductTwo(new int[]{2, 3, -2, 4}));
    }
}
