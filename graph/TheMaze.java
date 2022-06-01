package LeetCode.graph;

import java.util.*;

//https://leetcode.com/problems/the-maze/submissions/
public class TheMaze {
    private Map<String, int[]> map = Map.of("U", new int[]{-1, 0}, "D", new int[]{1, 0}, "R", new int[]{0, 1}, "L", new int[]{0, -1});
    private static final int[][] DIRECTIONS = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};

    //O(mn) time and space
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            maze[curr[0]][curr[1]] = 2;
            List<int[]> list = populate(maze, curr);
            for (int[] ints : list) {
                if (maze[ints[0]][ints[1]] == 2) continue;
                if (Arrays.equals(ints, destination)) {
                    return true;
                }
                queue.add(ints);
            }
        }
        return false;
    }

    private List<int[]> populate(int[][] maze, int[] curr) {
        List<int[]> list = new ArrayList<>();
        for (int[] dir : DIRECTIONS) {
            int x = curr[0];
            int y = curr[1];
            while (isValid(new int[]{x + dir[0], y + dir[1]}, maze)) {
                x += dir[0];
                y += dir[1];
            }
            if (x != curr[0] || y != curr[1]) list.add(new int[]{x, y});
        }
        return list;
    }

    private boolean isValid(int[] curr, int[][] maze) {
        return curr[0] >= 0 && curr[1] >= 0 && curr[0] < maze.length && curr[1] < maze[0].length && maze[curr[0]][curr[1]] != 1;
    }

    public boolean hasPathPremium(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue < int[] > queue = new LinkedList < > ();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            if (s[0] == destination[0] && s[1] == destination[1])
                return true;
            for (int[] dir: dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                if (!visited[x - dir[0]][y - dir[1]]) {
                    queue.add(new int[] {x - dir[0], y - dir[1]});
                    visited[x - dir[0]][y - dir[1]] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TheMaze theMaze = new TheMaze();
        System.out.println(theMaze.hasPath(new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}}, new int[]{0,4}, new int[]{4, 4}));
    }
}
