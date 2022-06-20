package LeetCode.graph;

import java.lang.reflect.Array;
import java.util.*;

public class NumberOfDistinctIslandsIII {
    private boolean[][] visited;
    private StringBuilder currentIsland;

    public int numDistinctIslands(int[][] grid) {
        HashSet<String> hashSet = new HashSet<>();
        visited = new boolean[grid.length][grid[0].length];
        currentIsland = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, "");
                    hashSet.add(currentIsland.toString());
                    currentIsland = new StringBuilder();
                }
            }
        }
        Arrays.equals(new int[1], new int[1]);
        return hashSet.size();
    }

    private void dfs(int[][] grid, int i, int j, String dir) {
        if (i < 0 || j < 0 || i >= grid.length
                || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) return;
        grid[i][j] = 0;
        visited[i][j] = true;
        currentIsland.append(dir);
        dfs(grid, i, j + 1, "R");
        dfs(grid, i + 1, j, "D");
        dfs(grid, i - 1, j, "U");
        dfs(grid, i, j - 1, "L");
        currentIsland.append('0');
    }

    public static void main(String[] args) {
        NumberOfDistinctIslandsIII number = new NumberOfDistinctIslandsIII();
        System.out.println(number.numDistinctIslands(new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}}));
    }
}
