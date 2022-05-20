package LeetCode.dynamic;

//https://leetcode.com/problems/target-sum/discuss/455024/DP-IS-EASY!-5-Steps-to-Think-Through-DP-Questions.
public class TargetSum {

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        System.out.println(targetSum.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int[] memo = new int[nums.length];
        return helper(0, target, 0, nums, memo);
    }

    private int helper(int curr, int target, int index, int[] nums, int[] memo) {
        if (index == nums.length) return curr == target ? 1 : 0;
        if (memo[index] != 0) {
            return memo[index];
        }
        int plus = helper(curr + nums[index], target, index + 1, nums, memo);
        int minus = helper(curr - nums[index], target, index + 1, nums, memo);
        memo[index] = plus + minus;
        return plus + minus;
    }
}
