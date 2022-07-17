package LeetCode.arrays;

import java.util.Arrays;

//link - https://leetcode.com/problems/3sum-closest/submissions/
public class ThreeSumClosest {
    public static void main(String[] args) {

    }

    public int threeSumClosestTwo(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, minDiff = Integer.MAX_VALUE;
        for (int s1 = 0; s1 < nums.length; s1++) {
            int left = s1 + 1, right = nums.length - 1;
            while (left < right) {
                int num = nums[s1] + nums[left] + nums[right];
                if (Math.abs(target - num) < minDiff) res = num;
                minDiff = Math.min(minDiff, Math.abs(target - num));
                if (num == target) return num;
                if (num < target) left++;
                else right--;
            }
        }
        return res;
    }

    public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE, sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (right > left) {
                int buffSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - (buffSum)) < minDiff) {
                    sum = buffSum;
                    minDiff = Math.abs(target - buffSum);
                    if (minDiff == 0) return sum;
                }
                if (buffSum > target) right--;
                else left++;
            }
        }
        return sum;
    }
}
