package LeetCode.graph;

import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/path-with-maximum-minimum-value/
public class PathWithMaximumMinimumValue {
    private int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    //mnlogk time
    public int maximumMinimumPath(int[][] grid) {
        int left = 0, right = (int) Math.pow(10, 9), lastCorrect = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (BFS(grid, mid)) {
                left = mid + 1;
                lastCorrect = mid;
            } else right = mid - 1;
        }
        return lastCorrect;
    }

    private boolean BFS(int[][] grid, int min) {
        if (grid[0][0] < min || grid[grid.length - 1][grid[0].length - 1] < min) return false;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : DIRECTIONS) {
                int i = curr[0] + dir[0];
                int j = curr[1] + dir[1];
                if (i == grid.length - 1 && j == grid[0].length - 1) return true;
                if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] < min) continue;
                visited[i][j] = true;
                queue.add(new int[]{i, j});
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PathWithMaximumMinimumValue path = new PathWithMaximumMinimumValue();
        System.out.println(path.maximumMinimumPath(new int[][]{{2,2,1,2,2,2},{1,2,2,2,1,2}}));
    }

}
