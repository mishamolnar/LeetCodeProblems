package LeetCode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/as-far-from-land-as-possible/submissions/
public class AsFarFromLandAsPossible {

    public static void main(String[] args) {
        AsFarFromLandAsPossible asFarFromLandAsPossible = new AsFarFromLandAsPossible();
        System.out.println(asFarFromLandAsPossible.maxDistance(new int[][]{{1,0,0}, {0,0,0}, {0,0,1}}));
    }

    private static final int[][] DIRECTIONS = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        int max = -1;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : DIRECTIONS) {
               int x = curr[0] + dir[0];
               int y = curr[1] + dir[1];
               if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y]) {
                   visited[x][y] = true;
                   grid[x][y] = 1 + grid[curr[0]][curr[1]];
                   queue.add(new int[]{x, y});
                   max = Math.max(grid[x][y], max);
               }
            }
        }
        return max > 0 ? max - 1 : -1;
    }
}
