package LeetCode.graph;

//link - https://leetcode.com/problems/number-of-islands/submissions/
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        if (x > 0 && grid[x - 1][y] == '1') dfs(grid, x - 1, y);
        if (y > 0 && grid[x][y - 1] == '1') dfs(grid, x, y - 1);
        if (x < grid.length - 1 && grid[x + 1][y] == '1') dfs(grid, x + 1, y);
        if (y < grid[0].length - 1 && grid[x][y + 1] == '1') dfs(grid, x, y + 1);
    }
}
