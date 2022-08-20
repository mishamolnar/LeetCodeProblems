package LeetCode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        long tar = target;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<List<Integer>> buff = twoSum(nums, j + 1, tar - nums[i] - nums[j]);
                for (List<Integer> integers : buff) {
                    ArrayList<Integer> quadruplet = new ArrayList<>(integers);
                    quadruplet.add(nums[i]);
                    quadruplet.add(nums[j]);
                    res.add(quadruplet);
                }
            }
        }
        res  = res.stream()
                .distinct()
                .collect(Collectors.toList());
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, long target) {
        int left = start, right = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (left < right) {
            if (nums[left] + nums[right] == target)
                res.add(List.of(nums[left], nums[right]));
            if (nums[left] + nums[right] > target) right--;
            else left++;
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(new int[]{2,2,2,2,2}, 8));
    }
}
