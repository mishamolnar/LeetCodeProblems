package LeetCode.matrixes;

import java.util.HashMap;
import java.util.Map;

public class MinimumKnightMoves {
    public int minKnightMoves(int x, int y) {
        HashMap<Map.Entry<Integer, Integer>, Integer> cache = new HashMap<>();
        x = Math.abs(x);
        y = Math.abs(y);
        return dfs(x, y, cache);
    }

    private int dfs(int x, int y, HashMap<Map.Entry<Integer, Integer>, Integer> cache) {
        if (cache.containsKey(Map.entry(x, y))) return cache.get(Map.entry(x, y));

        x = Math.abs(x);
        y = Math.abs(y);

        if (x == 0 && y == 0) return 0;

        if (x + y == 2) return 2;

        cache.put(Map.entry(x, y), Math.min(dfs(x - 1, y - 2, cache), dfs(x - 2, y - 1, cache)));

        return cache.get(Map.entry(x, y));
    }
}
