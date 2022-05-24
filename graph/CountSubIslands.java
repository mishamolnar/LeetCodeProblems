package LeetCode.graph;

//https://leetcode.com/problems/count-sub-islands/submissions/
public class CountSubIslands {
    private static final int[][] DIRECTIONS = new int[][]{{1,0}, {0, 1}, {-1, 0}, {0, -1}};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid2[i][j] == 1 && dfs(grid1, grid2, i, j)) res++;
            }
        }
        return res;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int x, int y) {
        if (x < 0 || y < 0 || x >= grid1.length || y >= grid1[0].length || grid2[x][y] == 0) return true;
        if (grid1[x][y] == 0) return false;
        grid2[x][y] = 0;
        boolean res = true;
        for (int[] dir : DIRECTIONS) {
            res &= dfs(grid1, grid2, x + dir[0], y + dir[1]);
        }
        return res;
    }
}
