package LeetCode.matrixes;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    private static final int[][] DIR = new int[][]{{-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        if (grid.length == 1) return 1;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid.length];
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int steps = 1;
        while (!queue.isEmpty()) {
            steps++;
            for (int i = queue.size(); i > 0; i--) {
                int[] curr = queue.poll();
                for (int[] d : DIR) {
                    int[] next = new int[]{curr[0] + d[0], curr[1] + d[1]};
                    if (next[0] < 0 || next[1] < 0 || next[0] >= grid.length || next[1] >= grid.length || grid[next[0]][next[1]] == 1)
                        continue;
                    if (next[0] == grid.length - 1 && next[1] == grid.length - 1)
                        return steps;
                    if (!visited[next[0]][next[1]]) {
                        queue.add(next);
                        visited[next[0]][next[1]] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix shortestPathInBinaryMatrix = new ShortestPathInBinaryMatrix();
        System.out.println(shortestPathInBinaryMatrix.shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
    }
}
