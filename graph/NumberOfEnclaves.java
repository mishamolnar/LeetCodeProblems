package LeetCode.graph;

//https://leetcode.com/problems/number-of-enclaves/
public class NumberOfEnclaves {
    private static final int[][] DIRECTIONS = new int[][]{{1,0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1)
                    dfs(grid, i, j);
            }
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) res++;
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) return;
        grid[x][y] = 0;
        for (int[] dir : DIRECTIONS) {
            dfs(grid, x + dir[0], y + dir[1]);
        }
    }

    public static void main(String[] args) {
        NumberOfEnclaves number = new NumberOfEnclaves();
        System.out.println(number.numEnclaves(new int[][]{{0}, {1}, {1}, {0}, {0}}));
    }
}
