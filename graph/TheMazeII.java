package LeetCode.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/the-maze-ii/submissions/
public class TheMazeII {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    //O(mn) space
    // O(mn log (mn)) time
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] distances = new int[maze.length][maze[0].length];
        for (int[] distance : distances) Arrays.fill(distance, Integer.MAX_VALUE);
        pq.add(new int[] {start[0], start[1], 0});
        distances[start[0]][start[1]] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            for (int[] dir : DIRECTIONS) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] != 1) {
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                if (curr[2] + Math.abs(x - curr[0]) + Math.abs(y - curr[1]) < distances[x][y]) {
                    if (x == destination[0] && y == destination[1]) return curr[2] + Math.abs(x - curr[0]) + Math.abs(y - curr[1]);
                    pq.add(new int[]{x, y, curr[2] + Math.abs(x - curr[0]) + Math.abs(y - curr[1])});
                    distances[x][y] = curr[2] + Math.abs(x - curr[0]) + Math.abs(y - curr[1]);
                }
            }
        }
        return -1;
    }

    //[[0,0,0,0,1,0,0],
    // [0,0,1,0,0,0,0],
    // [0,0,0,0,0,0,0],
    // [0,0,0,0,0,0,1],
    // [0,1,0,0,0,0,0],
    // [0,0,0,1,0,0,0],
    // [0,0,0,0,0,0,0],
    // [0,0,1,0,0,0,1],
    // [0,0,0,0,1,0,0]]
    //[0,0]
    //[8,6] -> 26

    public static void main(String[] args) {
        TheMazeII theMaze = new TheMazeII();
        System.out.println("aa".compareTo("bb"));
        System.out.println(theMaze.shortestDistance(new int[][]
                {{0 , 0 , 0 , 0 , 1 , 0 , 0} ,
                {0 , 0 , 1 , 0 , 0 , 0 , 0} ,
                {0 , 0 , 0 , 0 , 0 , 0 , 0} ,
                {0 , 0 , 0 , 0 , 0 , 0 , 1} ,
                {0 , 1 , 0 , 0 , 0 , 0 , 0} ,
                {0 , 0 , 0 , 1 , 0 , 0 , 0} ,
                {0 , 0 , 0 , 0 , 0 , 0 , 0} ,
                {0 , 0 , 1 , 0 , 0 , 0 , 1} ,
                {0 , 0 , 0 , 0 , 1 , 0 , 0}}, new int[]{0,0}, new int[]{8, 6}));
    }
}
