package LeetCode.graph;

import java.util.PriorityQueue;

public class MinimumCostToMakeAtLeastOneValidPath {
    private static final int[][] DIR = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private static final int[] CEL = new int[]{1, 3, 4, 2};

    public int minCost(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        pq.add(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            visited[curr[0]][curr[1]] = true;
            if (curr[0] == grid.length - 1 && curr[1] == grid[0].length - 1)
                return curr[2];
            for (int i = 0; i < 4; i++) {
                int x = curr[0] + DIR[i][0];
                int y = curr[1] + DIR[i][1];
                if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y])
                    continue;
                pq.add(new int[]{x, y, curr[2] + (CEL[i] == grid[curr[0]][curr[1]] ? 0 : 1)});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumCostToMakeAtLeastOneValidPath cost = new MinimumCostToMakeAtLeastOneValidPath();
        System.out.println(cost.minCost(new int[][]{{1,1,3},{3,2,2},{1,1,4}}));
    }
}
