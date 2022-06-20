package LeetCode.matrixes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/best-meeting-point/submissions/
public class BestMeetingPoint {
    private static final int[][] DIRECTIONS = new int[][]{{0 , 1}, {1, 0}, {-1, 0}, {0, -1}};


    //bfs - O(m2n2) complexity
    public int minTotalDistanceBFS(int[][] grid) {
        int[][][] distances = new int[grid.length][grid[0].length][2]; //0 - count, 1 sum of distances
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) bfs(distances, i, j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (distances[i][j][1] < min) min = distances[i][j][1];
            }
        }
        return min;
    }

    private void bfs(int[][][] distances, int i, int j) {
        distances[i][j][0]++;
        boolean[][] visited = new boolean[distances.length][distances[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : DIRECTIONS) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if (x < 0 || y < 0 || x >= distances.length || y >= distances[0].length || visited[x][y]) continue;
                visited[x][y] = true;
                distances[x][y][0]++;
                distances[x][y][1] += manhattan(i, j, x, y);
                queue.add(new int[]{x, y});
            }
        }
    }

    private int manhattan(int i, int j, int x, int y) {
        return Math.abs(i - x) + Math.abs(j - y);
    }


    //median solution
    // O(mn) space and time
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = collectRows(grid);
        List<Integer> cols = collectCols(grid);
        int row = rows.get(rows.size() / 2);
        int col = cols.get(cols.size() / 2);
        return minDistance1D(rows, row) + minDistance1D(cols, col);
    }

    private int minDistance1D(List<Integer> points, int origin) {
        int distance = 0;
        for (int point : points) {
            distance += Math.abs(point - origin);
        }
        return distance;
    }

    private List<Integer> collectRows(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rows.add(row);
                }
            }
        }
        return rows;
    }

    private List<Integer> collectCols(int[][] grid) {
        List<Integer> cols = new ArrayList<>();
        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == 1) {
                    cols.add(col);
                }
            }
        }
        return cols;
    }

    public static void main(String[] args) {
        BestMeetingPoint best = new BestMeetingPoint();
        System.out.println(best.minTotalDistance(new int[][]{{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}}));
    }
}
