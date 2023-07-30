package LeetCode.backTracking;

import java.util.Arrays;
import java.util.Map;

public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        int score = backtrack(nums, 0, nums.length - 1, true);
        return score >= (Arrays.stream(nums).sum() - score);
    }

    private int backtrack(int[] nums, int start, int end, boolean first) {
        if (start == end) {
            return nums[start];
        } else if (first) {
            return Math.max(nums[start] + backtrack(nums, start + 1, end, false),
                    nums[end] + backtrack(nums, start, end - 1, false));
        } else {
            return Math.min(nums[start] + backtrack(nums, start + 1, end, true),
                    nums[end] + backtrack(nums, start, end - 1, true));
        }
    }
}
