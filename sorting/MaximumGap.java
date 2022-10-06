package LeetCode.sorting;

import java.util.Arrays;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (min == max) return 0; // All elements are the same
        int bucketSize = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int[] mins = new int[nums.length];
        int[] maxs = new int[nums.length];
        Arrays.fill(mins, Integer.MAX_VALUE);
        Arrays.fill(maxs, Integer.MIN_VALUE);
        for (int num : nums) {
            int bucket = (num - min) / bucketSize;
            mins[bucket] = Math.min(mins[bucket], num);
            maxs[bucket] = Math.max(maxs[bucket], num);
        }
        int res = bucketSize;
        for (int i = 0; i < nums.length - 1; i++) {
            if (maxs[i] == Integer.MAX_VALUE) continue;
            res = Math.max(res, mins[i + 1] - maxs[i]);
        }
        return res;
    }
}
