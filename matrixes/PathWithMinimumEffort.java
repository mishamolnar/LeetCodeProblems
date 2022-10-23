package LeetCode.matrixes;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    private static final int[][] DIR = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); //0 -  max,1, - x, 2 - y
        pq.add(new int[]{0, 0 , 0});
        int[][] visited = new int[heights.length][heights[0].length];
        for (int[] ints : visited) Arrays.fill(ints, Integer.MAX_VALUE);
        visited[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[1] == heights.length - 1 && curr[2] == heights[0].length - 1)
                return curr[0];
            for (int[] d : DIR) {
                int x = curr[1] + d[0], y = curr[2] + d[1];
                if (x < 0 || y < 0 || x >= heights.length || y >= heights[0].length ||
                        visited[x][y] <= Math.max(curr[0], Math.abs(heights[curr[1]][curr[2]] - heights[x][y])))
                    continue;
                visited[x][y] = Math.max(curr[0], Math.abs(heights[curr[1]][curr[2]] - heights[x][y]));
                pq.add(new int[]{Math.max(curr[0], Math.abs(heights[curr[1]][curr[2]] - heights[x][y])), x, y});
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        PathWithMinimumEffort path = new PathWithMinimumEffort();
        System.out.println(path.minimumEffortPath(new int[][]{{1,2,2}, {3,8,2}, {5,3,5}}));
    }
}
