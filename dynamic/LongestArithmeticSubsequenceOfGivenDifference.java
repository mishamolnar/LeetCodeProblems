package LeetCode.dynamic;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : arr) {
            int score = map.getOrDefault(num - difference, 0) + 1;
            res = score + 1;
            map.put(num, score);
        }
        return res;
    }
}
