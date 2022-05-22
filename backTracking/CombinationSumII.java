package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/submissions/
public class CombinationSumII {

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        System.out.println(combinationSumII.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), 0, target, 0, candidates);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> curr, int currSum, int target, int index, int[] candidates) {
        if (currSum == target) {
            result.add(curr);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (currSum + candidates[i] > target || (i > 0 && candidates[i] == candidates[i - 1] && i - 1 >= index)) continue;
            curr.add(candidates[i]);
            backtrack(result, new ArrayList<>(curr), currSum + candidates[i], target, i + 1, candidates);
            curr.remove(curr.size() - 1);
        }
    }
}
