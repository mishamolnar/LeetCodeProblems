package LeetCode.arrays;

import java.util.HashSet;

//https://leetcode.com/problems/contains-duplicate-ii/
public class ContainsDuplicateII {

    public static void main(String[] args) {
        ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();
        System.out.println(containsDuplicateII.containsNearbyDuplicate(new int[]{1,2,3,4,1}, 3));
    }

    //o(n) time and O(k) space
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i - left > k) {
                set.remove(nums[left]);
                left++;
            }
            if (set.contains(nums[i])) return true;
            else set.add(nums[i]);
        }
        return false;
    }
}
