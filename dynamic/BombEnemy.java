package LeetCode.dynamic;

import java.util.Arrays;

//https://leetcode.com/problems/bomb-enemy/
public class BombEnemy {

    //O(mn) time and O(m) space
    public int maxKilledEnemies(char[][] grid) {
        int[] columns = new int[grid[0].length];
        int[] row = new int[grid[0].length];
        Arrays.fill(columns, -1);
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            int sum = 0;
            Arrays.fill(row, 0);
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'E') sum++;
                else if (grid[i][j] == 'W') {
                    row[j] = 0;
                    sum = 0;
                } else row[j] += sum;
            }
            sum = 0;
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (grid[i][j] == 'E') sum++;
                else if (grid[i][j] == 'W') {
                    row[j] = 0;
                    sum = 0;
                } else row[j] += sum;
            }
            for (int j = 0; j < grid[i].length; j++) {
                if (columns[j] == -1) calculateForColumn(grid, columns, i, j);
                if (grid[i][j] == 'E') continue;
                else if (grid[i][j] == 'W') columns[j] = -1;
                else {
                    if (columns[j] == -1) calculateForColumn(grid, columns, i, j);
                    ans = Math.max(ans, columns[j] + row[j]);
                }
            }
        }
        return ans;
    }

    private void calculateForColumn(char[][] grid, int[] columns, int row, int col) {
        int sum = 0;
        for (int i = row; i < grid.length; i++) {
            if (grid[i][col] == 'W') break;
            if (grid[i][col] == 'E') sum++;
        }
        columns[col] = sum;
    }

    public static void main(String[] args) {
        BombEnemy bombEnemy = new BombEnemy();
        bombEnemy.maxKilledEnemies(new char[][]{{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}});
    }

    public int maxKilledEnemiesPremium(char[][] grid) {
        if (grid.length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int maxCount = 0, rowHits = 0;
        int[] colHits = new int[cols];

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {

                // reset the hits on the row, if necessary.
                if (col == 0 || grid[row][col - 1] == 'W') {
                    rowHits = 0;
                    for (int k = col; k < cols; ++k) {
                        if (grid[row][k] == 'W')
                            // stop the scan when we hit the wall.
                            break;
                        else if (grid[row][k] == 'E')
                            rowHits += 1;
                    }
                }

                // reset the hits on the column, if necessary.
                if (row == 0 || grid[row - 1][col] == 'W') {
                    colHits[col] = 0;
                    for (int k = row; k < rows; ++k) {
                        if (grid[k][col] == 'W')
                            break;
                        else if (grid[k][col] == 'E')
                            colHits[col] += 1;
                    }
                }

                // run the calculation for the empty cell.
                if (grid[row][col] == '0') {
                    maxCount = Math.max(maxCount, rowHits + colHits[col]);
                }
            }
        }

        return maxCount;
    }
}
