package LeetCode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class LongestSquareStreakInArray {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (Math.sqrt(nums[i]) == Math.floor(Math.sqrt(nums[i]))) {
                map.put(nums[i], map.getOrDefault( (int) Math.sqrt(nums[i]), 0) + 1);
            } else map.put(nums[i], 1);
        }
        return map.values().stream().filter(n -> n > 2).max(Integer::compareTo).orElse(-1);
    }
}
