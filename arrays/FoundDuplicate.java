package LeetCode.arrays;

import java.util.Arrays;

//hashset solution - O(n) - space and time
//sort solution - O(n log(n)) time, space - O(1)
//link https://leetcode.com/problems/contains-duplicate/
class FoundDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
}
