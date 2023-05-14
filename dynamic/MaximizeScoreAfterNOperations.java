package LeetCode.dynamic;

import java.util.Arrays;

public class MaximizeScoreAfterNOperations {
    public int maxScore(int[] nums) {
        int memoSize = 1 << nums.length; // 2^(nums array size)
        int[] memo = new int[memoSize];
        Arrays.fill(memo, -1);
        return maxScore(nums, 0, 1, memo);
    }

    private int maxScore(int[] nums, int mask, int step, int[] memo) {
        if (memo[mask] != -1) {
            return memo[mask];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (((mask >> i) & 1) == 0 && ((mask >> j) & 1) == 0) {
                    int newMask = mask | (1 << i) | (1 << j);
                    res = Math.max(gcd(nums[i], nums[j]) * step + maxScore(nums, newMask, step + 1, memo), res);
                }
            }
        }
        memo[mask] = res;
        return res;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }


    public static void main(String[] args) {
        System.out.println(new MaximizeScoreAfterNOperations().maxScore(new int[]{1,2,3,4,5,6}));
    }
}
