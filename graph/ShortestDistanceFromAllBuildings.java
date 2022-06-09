package LeetCode.graph;

import java.util.*;

//https://leetcode.com/problems/shortest-distance-from-all-buildings/solution/
public class ShortestDistanceFromAllBuildings {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    //solution for total manhatten distance
    public int shortestDistance(int[][] grid) {
        int[][][] counts = new int[grid.length][grid[0].length][2]; //1 - buildings counts, 2 - sum of distances
        int buildingCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    buildingCount++;
                    bfs(grid, counts, i, j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (counts[i][j][0] == buildingCount) {
                    min = Math.min(min, counts[i][j][1]);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void bfs(int[][] grid, int[][][] counts, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : DIRECTIONS) {
               int x = curr[0] + dir[0];
               int y = curr[1] + dir[1];
               if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length
                       || visited[x][y] || grid[x][y] == 1 || grid[x][y] == 2) continue;
               visited[x][y] = true;
               counts[x][y][0]++;
               counts[x][y][1] += manhattan(x, y, i, j);
               queue.add(new int[]{x, y});
            }
        }
    }

    private int manhattan(int x, int y, int i, int j) {
        return Math.abs(x - i) + Math.abs(y - j);
    }

    public int shortestDistanceNotManhatten(int[][] grid) {
        // Next four directions.
        int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int rows = grid.length;
        int cols = grid[0].length;

        // Total Mtrix to store total distance sum for each empty cell.
        int[][] total = new int[rows][cols];

        int emptyLandValue = 0;
        int minDist = Integer.MAX_VALUE;

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {

                // Start a BFS from each house.
                if (grid[row][col] == 1) {
                    minDist = Integer.MAX_VALUE;

                    // Use a queue to perform a BFS, starting from the cell at (r, c).
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{ row, col });

                    int steps = 0;

                    while (!q.isEmpty()) {
                        steps++;

                        for (int level = q.size(); level > 0; --level) {
                            int[] curr = q.poll();

                            for (int[] dir : dirs) {
                                int nextRow = curr[0] + dir[0];
                                int nextCol = curr[1] + dir[1];

                                // For each cell with the value equal to empty land value
                                // add distance and decrement the cell value by 1.
                                if (nextRow >= 0 && nextRow < rows &&
                                        nextCol >= 0 && nextCol < cols &&
                                        grid[nextRow][nextCol] == emptyLandValue) {
                                    grid[nextRow][nextCol]--;
                                    total[nextRow][nextCol] += steps;

                                    q.offer(new int[]{ nextRow, nextCol });
                                    minDist = Math.min(minDist, total[nextRow][nextCol]);
                                }
                            }
                        }
                    }

                    // Decrement empty land value to be searched in next iteration.
                    emptyLandValue--;
                }
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    public static void main(String[] args) {
        ShortestDistanceFromAllBuildings shortestDistanceFromAllBuildings = new ShortestDistanceFromAllBuildings();
        System.out.println(shortestDistanceFromAllBuildings.shortestDistanceNotManhatten(new int[][]{{1,1,1,1,1,0},{0,0,0,0,0,1},{0,1,1,0,0,1},{1,0,0,1,0,1},{1,0,1,0,0,1},{1,0,0,0,0,1},{0,1,1,1,1,0}}));
    }
}
