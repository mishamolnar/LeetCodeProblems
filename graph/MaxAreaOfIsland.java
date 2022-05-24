package LeetCode.graph;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/max-area-of-island/submissions/
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}}));
    }

    //bfs - O(nm) time and space
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] marked = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (marked[i][j] || grid[i][j] != 1) continue;
                maxArea = Math.max(maxArea, BFS(grid, marked, i, j));
            }
        }
        return maxArea;
    }

    private int BFS(int[][] grid, boolean[][] marked, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int area = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (marked[curr[0]][curr[1]]) continue;
            marked[curr[0]][curr[1]] = true;
            if (curr[0] > 0 && !marked[curr[0] - 1][curr[1]] && grid[curr[0] - 1][curr[1]] == 1) queue.add(new int[]{curr[0] - 1, curr[1]});
            if (curr[1] > 0 && !marked[curr[0]][curr[1] - 1] && grid[curr[0]][curr[1] - 1] == 1) queue.add(new int[]{curr[0], curr[1] - 1});
            if (curr[0] < marked.length - 1 && !marked[curr[0] + 1][curr[1]] && grid[curr[0] + 1][curr[1]] == 1) queue.add(new int[]{curr[0] + 1, curr[1]});
            if (curr[1] < marked[0].length - 1 && !marked[curr[0]][curr[1] + 1] && grid[curr[0]][curr[1] + 1] == 1) queue.add(new int[]{curr[0], curr[1] + 1});
            area++;
        }
        return area;
    }

    // dfs - O(nm) time but constant space
    public int maxAreaOfIslandDFS(int[][] grid) {
        int max_area = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == 1) max_area = Math.max(max_area, AreaOfIsland(grid, i, j));
        return max_area;
    }

    public int AreaOfIsland(int[][] grid, int i, int j){
        if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + AreaOfIsland(grid, i+1, j) + AreaOfIsland(grid, i-1, j) + AreaOfIsland(grid, i, j-1) + AreaOfIsland(grid, i, j+1);
        }
        return 0;
    }
}
