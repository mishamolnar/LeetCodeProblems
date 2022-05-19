package LeetCode.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public static void main(String[] args) {
        MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves moves = new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves();
        System.out.println(moves.minDifference(new int[]{6,6,0,1,1,4,6}));
    }

    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            minDiff = Math.min(minDiff, nums[nums.length - 1 - (3 - i)] - nums[i]);
        }
        return minDiff;
    }
}
