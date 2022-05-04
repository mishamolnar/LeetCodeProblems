package LeetCode.backTracking;

import java.util.*;

// link - https://leetcode.com/problems/combination-sum/
public class CombinationSum {


    //time complexity - O(N^target) and space - O(target)
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); //сортуємо масив для унікальності значень
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if (remain < 0) return; //додали забагато
        else if (remain == 0) list.add(new ArrayList<>(tempList)); //норм додали, додаємо до відповіді
        else{
            for(int i = start; i < nums.length; i++) { //числа йдуть завжди по зростанню тому ми не можемо получити одну комбінацію з різною перестановкою
                tempList.add(nums[i]); //пробуємо додати
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);//забираємо попередньо додане
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2, 3, 5}, 15));
    }
}
