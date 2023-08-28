package LeetCode.dynamic;

import java.util.Arrays;

public class MinMaxDifferenceOfAPair {
    public int minimizeMax(int[] nums, int pairs) {
        Arrays.sort(nums);
        int[][] dp = new int[nums.length][pairs + 1];
        for (int idx = 0; idx < nums.length; idx++) {
            for (int p = 1; p <= pairs && p <= (idx + 1) / 2; p++) {
                int prevPair = idx - 2 >= 0 ? dp[idx - 2][p - 1] : 0;
                dp[idx][p] = Math.max(nums[idx] - nums[idx - 1], prevPair);
                if (idx >= p * 2) {
                    dp[idx][p] = Math.min(dp[idx][p], dp[idx - 1][p]);
                }
            }
        }
        return dp[nums.length - 1][pairs];
    }

    public static void main(String[] args) {
        System.out.println(new MinMaxDifferenceOfAPair().minimizeMax(new int[]{10,1,2,7,1,3}, 2));
    }


    private int countValidPairs(int[] nums, int threshold) {
        int index = 0, count = 0;
        while (index < nums.length - 1) {
            // If a valid pair is found, skip both numbers.
            if (nums[index + 1] - nums[index] <= threshold) {
                count++;
                index++;
            }
            index++;
        }
        return count;
    }

    public int minimizeMaxBinarySearch(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If there are enough pairs, look for a smaller threshold.
            // Otherwise, look for a larger threshold.
            if (countValidPairs(nums, mid) >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
