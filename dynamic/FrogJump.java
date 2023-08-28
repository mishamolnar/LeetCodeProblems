package LeetCode.dynamic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {
    public boolean canCross(int[] stones) {
        Set<Integer>[] dp = new Set[stones.length];
        for (int i = 0; i < dp.length; i++) dp[i] = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }

        dp[0].add(1);
        for (int i = 0; i < stones.length; i++) {
            for (Integer jump : dp[i]) {
                int next = stones[i] + jump;
                if (map.containsKey(next)) {
                    int index = map.get(next);
                    dp[index].add(jump);
                    dp[index].add(jump + 1);
                    if (jump > 1)
                        dp[index].add(jump - 1);
                }
            }
        }
        return !dp[stones.length - 1].isEmpty();
    }
}
