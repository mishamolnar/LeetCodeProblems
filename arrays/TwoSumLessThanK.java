package LeetCode.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/two-sum-less-than-k/
public class TwoSumLessThanK {

    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, sum = -1;
        while (left < right) {
            if (nums[left] + nums[right] >= k) right--;
            else sum = Math.max(sum, nums[left++] + nums[right]);
        }
        return sum;
    }

    //O(n + m) where m - range of ints
    public int twoSumLessThanKCountSort(int[] nums, int k) {
        int answer = -1;
        int[] count = new int[1001];
        for (int num : nums) {
            count[num]++;
        }
        int lo = 1;
        int hi = 1000;
        while (lo <= hi) {
            if (lo + hi >= k || count[hi] == 0) {
                hi--;
            } else {
                if (count[lo] > (lo < hi ? 0 : 1)) {
                    answer = Math.max(answer, lo + hi);
                }
                lo++;
            }
        }
        return answer;
    }
}
