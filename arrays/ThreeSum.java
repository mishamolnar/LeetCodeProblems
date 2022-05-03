package LeetCode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// link - https://leetcode.com/problems/3sum/
public class ThreeSum {

    // constant memory and n2 time
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i > 0 && nums[i] == nums[i - 1]) || nums[i] > 0) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (-nums[i] > nums[left] + nums[right]) left++;
                else if (-nums[i] < nums[left] + nums[right]) right--;
                else {
                    if (result.size() == 0 || !result.get(result.size() -1).equals(List.of(nums[i], nums[left], nums[right]))) {
                        result.add(List.of(nums[i], nums[left], nums[right]));
                    }
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{}));
    }
}
