package LeetCode.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
public class ShortestPathInAGridWithObstaclesElimination {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    //O(m n k) complexity
    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        int[][] minEliminated = new int[rows][cols];
        for (int[] ints : minEliminated) Arrays.fill(ints, Integer.MAX_VALUE); // скільки потрібно було прибрати стін шо б дійти до даної клітинки
        minEliminated[0][0] = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0}); //x, y, obstacles eliminated for current cell
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == rows - 1 && curr[1] == cols - 1) return steps;
                for (int[] dir : DIRECTIONS) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x < 0 || y < 0 || x >= rows || y >= cols ||
                        curr[2] + grid[x][y] > k || curr[2] + grid[x][y] >= minEliminated[x][y]) continue; //додаємо тільки якщо ми дістались до даної клітинки в перший раз або за меншу кількість знесених стін
                    minEliminated[x][y] = curr[2] + grid[x][y];
                    queue.add(new int[]{x, y, curr[2] + grid[x][y]});
                }
            }
            steps++;
        }
        return -1;
    }
}
