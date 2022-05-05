package LeetCode.backTracking;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


//link - https://leetcode.com/problems/permutations/
//O(N * N!) time complexity
// O(n) space
public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] available = new boolean[nums.length];
        Arrays.fill(available, true);
        helper(result, new ArrayList<>(), available, nums);
        return result;
    }

    private void helper(List<List<Integer>> result, ArrayList<Integer> temp, boolean[] available, int[] nums) {
        if (temp.size() == nums.length) result.add(new ArrayList<>(temp));
        for (int i = 0; i < available.length; i++) {
            if (!available[i]) continue;
            temp.add(nums[i]);
            available[i] = false;
            helper(result, temp, available, nums);
            temp.remove(temp.size() - 1);
            available[i] = true;
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        System.out.println(permutation.permute(new int[]{1, 2, 3, 5, 6, 7, 8, 9, 10}));
    }
}
