package LeetCode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/split-array-largest-sum/submissions/
public class SplitArrayLargestSum {

    //O(log(right) * m)
    public int splitArray(int[] nums, int m) {
        int right = 0, left = 0, res = 0;
        for (int num : nums) {
            right += num;
            left = Math.max(num, left);
        }
        if (m == 1) return left;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDivide(nums, m, mid)) {
                res = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return res;
    }

    private boolean canDivide(int[] nums, int m, int sum) {
        int curr = 0;
        for (int num : nums) {
            if (curr + num > sum) {
                curr = 0;
                m--;
            }
            curr += num;
        }
        if (curr > 0) m--;
        return m >= 0;
    }


    //tle dp + memo
    public int splitArrayDynamic(int[] nums, int m) {
        if (m == 1) return Arrays.stream(nums).sum();
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return helper(nums, 0, m, new HashMap<>());
    }

    private int helper(int[] nums, int start, int m, HashMap<Map.Entry<Integer,Integer>, Integer> memo) {
        if (memo.containsKey(Map.entry(start, m)))
            return memo.get(Map.entry(start, m));

        if (m == 2)
            return splitArrayOnTwo(nums, start);

        int maxSum = Integer.MAX_VALUE, offset = start > 0 ? nums[start - 1] : 0;

        for (int i = start; i < nums.length - (m - 1); i++) {
            maxSum = Math.min(maxSum, Math.max(nums[i] - offset, helper(nums, i + 1, m - 1, memo)));
        }

        memo.put(Map.entry(start, m), maxSum);

        return maxSum;
    }

    public int splitArrayOnTwo(int[] nums, int start) {

        int maxSum = Integer.MAX_VALUE, offset = start > 0 ? nums[start - 1] : 0;
        for (int i = start; i < nums.length; i++) {
            maxSum = Math.min(maxSum, Math.max(nums[i] - offset, nums[nums.length - 1] - nums[i]));
        }

        return maxSum;
    }


    public static void main(String[] args) {
        SplitArrayLargestSum splitArrayLargestSum = new SplitArrayLargestSum();
        System.out.println(splitArrayLargestSum.splitArray(new int[]{1,2,3,4,5}, 2));
    }
}
