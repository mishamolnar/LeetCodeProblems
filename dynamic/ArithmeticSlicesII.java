package LeetCode.dynamic;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlicesII {
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        Map<Integer, Integer>[] dp = new Map[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];

                if (diff <= Integer.MIN_VALUE || diff >= Integer.MAX_VALUE)
                    continue;

                int intDiff = (int) diff;
                int current = dp[i].getOrDefault(intDiff, 0);
                int prev = dp[j].getOrDefault(intDiff, 0);

                dp[i].put(intDiff, current + prev + 1);
                res += prev;
            }
        }
        return res;
    }
}
