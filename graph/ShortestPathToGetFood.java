package LeetCode.graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-to-get-food/submissions/
public class ShortestPathToGetFood {
    private static final int[][] DIRECTIONS = new int[][]{{1,0}, {0, 1}, {-1, 0}, {0, -1}};

    //O(mn) time and space
    public int getFood(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '*') queue.add(new int[]{i, j, 0});
            }
        }
        if (queue.isEmpty()) return -1;
        grid[queue.peek()[0]][queue.peek()[1]] = '#';
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            for (int[] dir : DIRECTIONS) {
                int i = arr[0] + dir[0];
                int j = arr[1] + dir[1];
                if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 'X') continue;
                if (grid[i][j] == '#') return arr[2] + 1;
                grid[i][j] = 'X';
                queue.add(new int[]{i, j, arr[2] + 1});
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        ShortestPathToGetFood shortestPathToGetFood = new ShortestPathToGetFood();
        System.out.println(shortestPathToGetFood.getFood(new char[][]
                {{'X','X','X','X','X','X','X','X'},
                {'X','*','O','X','O','#','O','X'},
                {'X','O','O','X','O','O','X','X'},
                {'X','O','O','O','O','#','O','X'},
                {'X','X','X','X','X','X','X','X'}}));
    }
}
