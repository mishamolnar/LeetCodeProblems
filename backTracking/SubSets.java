package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// link https://leetcode.com/problems/subsets/
public class SubSets {

    // time - O(n)
    // space - O(1)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // відсортувати для унікальності
        backtrack(result, nums, new ArrayList<>(), 0, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, List<Integer> tempList, int startNum, int startIndex) {
        result.add(new ArrayList<>(tempList));
        for (int i = startNum; i < nums.length; i++) { //не запускається, а тому виходить з рекурсії якщо дійшли до останнього найбільшого елемента
            tempList.add(nums[i]); // якщо nums - {1, 2, 3} то запуститься такий самий алгоритм 3 рази, просто tempList буде не пустий, а з 1 або 2 або 3
            backtrack(result, nums, tempList, i + 1, startIndex + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        System.out.println(subSets.subsets(new int[]{1, 2, 3}));
    }
}
