package LeetCode.graph;


//https://leetcode.com/problems/number-of-closed-islands/
public class NumberOfClosedIslands {

    public static void main(String[] args) {
        NumberOfClosedIslands number = new NumberOfClosedIslands();
        System.out.println(number.closedIsland(new int[][]{
                {0 , 0 , 1 , 1 , 0 , 1 , 0 , 0 , 1 , 0} ,
                {1 , 1 , 0 , 1 , 1 , 0 , 1 , 1 , 1 , 0} ,
                {1 , 0 , 1 , 1 , 1 , 0 , 0 , 1 , 1 , 0} ,
                {0 , 1 , 1 , 0 , 0 , 0 , 0 , 1 , 0 , 1} ,
                {0 , 0 , 0 , 0 , 0 , 0 , 1 , 1 , 1 , 0} ,
                {0 , 1 , 0 , 1 , 0 , 1 , 0 , 1 , 1 , 1} ,
                {1 , 0 , 1 , 0 , 1 , 1 , 0 , 0 , 0 , 1} ,
                {1 , 1 , 1 , 1 , 1 , 1 , 0 , 0 , 0 , 0} ,
                {1 , 1 , 1 , 0 , 0 , 1 , 0 , 1 , 0 , 1} ,
                {1 , 1 , 1 , 0 , 1 , 1 , 0 , 1 , 1 , 0}}));
    }

    //0 island // 1 water
    public int closedIsland(int[][] grid) {
        int num = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 0 && isClosed(grid, i, j)) {
                    num++;
                }
            }
        }
        return num;
    }


    //dfs
    private boolean isClosed(int[][] grid, int x, int y) {
        if (x == 0 || y == 0 || x == grid.length - 1 || y == grid[0].length - 1) return false;
        if (grid[x][y] == 1) return true;
        grid[x][y] = 1;
        boolean top = grid[x - 1][y] == 1 || isClosed(grid, x - 1, y);
        boolean left = grid[x][y - 1] == 1 || isClosed(grid, x, y - 1);
        boolean bottom = grid[x + 1][y] == 1 || isClosed(grid, x + 1, y);
        boolean right = grid[x][y + 1] == 1 || isClosed(grid, x, y + 1);
        return top && left && bottom && right;
    }

/*

[
[0 , 0 , 1 , 1 , 0 , 1 , 0 , 0 , 1 , 0] ,
[1 , 1 , 0 , 1 , 1 , 0 , 1 , 1 , 1 , 0] ,
[1 , 0 , 1 , 1 , 1 , 0 , 0 , 1 , 1 , 0] ,
[0 , 1 , 1 , 0 , 0 , 0 , 0 , 1 , 0 , 1] ,
[0 , 0 , 0 , 0 , 0 , 0 , 1 , 1 , 1 , 0] ,
[0 , 1 , 0 , 1 , 0 , 1 , 0 , 1 , 1 , 1] ,
[1 , 0 , 1 , 0 , 1 , 1 , 0 , 0 , 0 , 1] ,
[1 , 1 , 1 , 1 , 1 , 1 , 0 , 0 , 0 , 0] ,
[1 , 1 , 1 , 0 , 0 , 1 , 0 , 1 , 0 , 1] ,
[1 , 1 , 1 , 0 , 1 , 1 , 0 , 1 , 1 , 0]]

[
[1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1] ,
[1 , 1 , 0 , 1 , 1 , 1 , 1 , 1 , 1 , 1] ,
[1 , 0 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1] ,
[1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 0 , 1] ,
[1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1] ,
[1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1] ,
[1 , 0 , 1 , 0 , 1 , 1 , 1 , 1 , 1 , 1] ,
[1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1] ,
[1 , 1 , 1 , 1 , 0 , 1 , 1 , 1 , 1 , 1] ,
[1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1]]

* */

}
