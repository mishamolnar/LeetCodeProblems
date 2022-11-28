package LeetCode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPlayersWithZeroLoses {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            map.putIfAbsent(match[0], 0);
            map.put(match[1], map.getOrDefault(match[1], 0) + 1);
        }
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) list.get(0).add(entry.getKey());
            else if (entry.getValue() == 1) list.get(1).add(entry.getKey());
        }
        list.get(0).sort(Integer::compareTo);
        list.get(1).sort(Integer::compareTo);
        return list;
    }
}
