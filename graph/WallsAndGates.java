package LeetCode.graph;

import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/walls-and-gates/
public class WallsAndGates {
    private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    //O(mn) space and time
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) queue.add(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : DIRECTIONS) {
                int i = curr[0] + dir[0];
                int j = curr[1] + dir[1];
                if (i >= rooms.length || i < 0 || j >= rooms[0].length || j < 0 || rooms[i][j] != Integer.MAX_VALUE) continue;
                rooms[i][j] = rooms[curr[0]][curr[1]] + 1;
                queue.add(new int[]{i, j});
            }
        }
    }
}
