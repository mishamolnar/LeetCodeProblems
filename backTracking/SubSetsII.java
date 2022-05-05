package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(result, nums, new ArrayList<Integer>(), 0);
        return result;
    }

    private void helper(List<List<Integer>> result, int[] nums, List<Integer> tempList, int start) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) { // нам не потрібна умова виходу, бо якщо ми на останньому елементі ми просто не будемо ітеруватись
            if (i > start && nums[i] == nums[i - 1]) continue; // не додаєм дублікат, тільки якщо він був в int[] nums - тоді додаєм
            tempList.add(nums[i]); // додаємо
            helper(result, nums, tempList, i + 1);
            tempList.remove(tempList.size() - 1); // забираємо
        }
    }

    public static void main(String[] args) {
        SubSetsII subSetsII = new SubSetsII();
        System.out.println(subSetsII.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
