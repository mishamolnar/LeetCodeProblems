package LeetCode.graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] nums) {
        Map<Integer, Map<Integer, Integer>> nextInt = new HashMap<>();
        int res = 2;
        for (int i = 0; i < nums.length; i++) {
            for (Map.Entry<Integer, Integer> diffAndCount : nextInt.getOrDefault(nums[i], Collections.emptyMap()).entrySet()) {
                int diff = diffAndCount.getKey();
                int count = diffAndCount.getValue();
                int nextIntValue = nums[i] + diff;
                nextInt.putIfAbsent(nextIntValue, new HashMap<>());
                nextInt.get(nextIntValue).putIfAbsent(diff, count + 1);
                res = Math.max(res, count + 1);
            }
            for (int j = i - 1; j >= 0; j--) {
                nextInt.putIfAbsent(nums[i] + (nums[i] - nums[j]), new HashMap<>());
                nextInt.get(nums[i] + (nums[i] - nums[j])).putIfAbsent(nums[i] - nums[j], 2);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestArithmeticSubsequence longest = new LongestArithmeticSubsequence();
        System.out.println(longest.longestArithSeqLength(new int[]{3,6,9,12}));
    }
}
