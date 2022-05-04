package LeetCode.backTracking;


// link - https://leetcode.com/problems/combination-sum-iv/
public class CombinationSumIV {

    // time complexity O(nm) space - O(n), where n - target, m - nums.length
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int num : nums) {
            if (num < dp.length) dp[num] = 1;
        }
        for (int i = 1; i < target + 1; i++) {
            int sum = 0;
            for (int num : nums) {
                if (num < i) sum += dp[i - num];
            }
            dp[i] += sum;
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSumIV combinationSumIV = new CombinationSumIV();
//        System.out.println(combinationSumIV.combinationSum4(new int[]{3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}, 10));
        System.out.println(combinationSumIV.combinationSum4(new int[]{1,2,3}, 5));
    }
}
