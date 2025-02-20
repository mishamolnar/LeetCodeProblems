package LeetCode.graph;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/number-of-distinct-islands/solution/
public class NumberOfDistinctIslandsByPattern {
    private int[][] grid;
    private boolean[][] visited;
    private StringBuffer currentIsland;

    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        this.visited = new boolean[grid.length][grid[0].length];
        Set<String> islands = new HashSet<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                currentIsland = new StringBuffer();
                dfs(row, col, '0');
                if (currentIsland.length() == 0) {
                    continue;
                }
                islands.add(currentIsland.toString());
            }
        }
        return islands.size();
    }

    private void dfs(int row, int col, char dir) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;
        if (visited[row][col] || grid[row][col] == 0) return;
        visited[row][col] = true;
        currentIsland.append(dir);
        dfs(row + 1, col, 'D');
        dfs(row - 1, col, 'U');
        dfs(row, col + 1, 'R');
        dfs(row, col - 1, 'L');
        currentIsland.append('0');
    }
}
