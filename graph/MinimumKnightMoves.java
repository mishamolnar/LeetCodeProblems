package LeetCode.graph;

import java.util.*;

//https://leetcode.com/problems/minimum-knight-moves/
public class MinimumKnightMoves {
    private Map<String, Integer> memo = new HashMap<>();

    //time and space - O(xy)
    //for bfs it is O(max(x,y)^2)
    public int minKnightMoves(int x, int y) {
        return dfs(Math.abs(x), Math.abs(y));
    }

    private int dfs(int x, int y) {
        String key = x + "," + y;
        if (memo.containsKey(key)) return memo.get(key);

        if (x + y == 0) return 0;
        else if (x + y == 2) return 2;
        else {
            int path = 1 + Math.min(dfs(Math.abs(x - 1), Math.abs(y - 2)), dfs(Math.abs(x - 2), Math.abs(y - 1)));
            memo.put(key, path);
            return path;
        }
    }

    public static void main(String[] args) {
        MinimumKnightMoves minimumKnightMoves = new MinimumKnightMoves();
        System.out.println(minimumKnightMoves.minKnightMoves(2, 112));
    }
}
