package LeetCode.greedy;

import java.util.HashMap;
import java.util.Map;

public class MinimumRounds {
    public int minimumRounds(int[] tasks) {
        //num % 3 -> 0 (0), 1 (1), 2(2);
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int res = 0;
        for (int count : map.values()) {
            if (count == 1) {
                return -1;
            }
            res += (count / 3);
            if (count % 3 > 0) {
                res++;
            }
        }
        return res;
    }
}
