package LeetCode.backTracking;

import java.util.*;

//https://leetcode.com/problems/permutations-ii/
public class PermutationII {
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]

    public static void main(String[] args) {
        PermutationII permutationII = new PermutationII();
        System.out.println(permutationII.permuteUnique(new int[]{1,1,2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, nums, new boolean[nums.length], new ArrayList<>());
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, boolean[] used, List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(current);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i + 1 < nums.length && nums[i] == nums[i + 1] && !used[i + 1])) continue;
            used[i] = true;
            current.add(nums[i]);
            backtrack(result, nums, used, new ArrayList<>(current));
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
