package LeetCode.matrixes;

import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/
public class RottingOranges {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) queue.add(new int[]{i, j});
            }
        }
        int steps = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] curr = queue.poll();
                for (int[] dir : DIRECTIONS) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x < 0 || y < 0 || x > grid.length || y > grid[0].length || grid[x][y] != 1) continue;
                    grid[x][y] = 2;
                    queue.add(new int[]{x, y});
                }
            }
            steps++;
        }
        return steps;
    }
}
