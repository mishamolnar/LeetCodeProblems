package LeetCode.sorting;

import java.util.Arrays;

public class FrequencyOfTheMostFrequent {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, res = 0;
        long sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum + k < (long) nums[right] * (right - left + 1)) {
                sum -= nums[left++];
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
