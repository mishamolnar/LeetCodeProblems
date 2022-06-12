package LeetCode.graph;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/the-maze-iii/submissions/
public class TheMazeIII {
    private static final Map<int[], String> DIRECTIONS = Map.of(new int[]{0, 1}, "r", new int[]{1, 0}, "d", new int[]{-1, 0}, "u", new int[]{0, -1}, "l");

    //O(mn) space
    // O(mn log (mn)) time
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] distances = new int[maze.length][maze[0].length];
        for (int[] distance : distances) Arrays.fill(distance, Integer.MAX_VALUE);
        String[][] moves = new String[maze.length][maze[0].length];
        distances[ball[0]][ball[1]] = 0;
        pq.add(new int[]{ball[0], ball[1], 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            String prevMoves = moves[curr[0]][curr[1]] == null ? "" : moves[curr[0]][curr[1]];
            for (Map.Entry<int[], String> entry : DIRECTIONS.entrySet()) {
                int[] dir = entry.getKey();
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length
                        && maze[x][y] != 1 && (x != hole[0] || y != hole[1])) {
                    x += dir[0];
                    y += dir[1];
                }
                if (x != hole[0] || y != hole[1]) {
                    x -= dir[0];
                    y -= dir[1];
                }
                int distance = curr[2] + Math.abs(x - curr[0]) + Math.abs(y - curr[1]);
                if (distance < distances[x][y]
                        || (distance == distances[x][y]
                        && (prevMoves + entry.getValue()).compareTo(moves[x][y] == null ? "" : moves[x][y]) < 0)) {
                    distances[x][y] = distance;
                    moves[x][y] = prevMoves + entry.getValue();
                    if (x != hole[0] || y != hole[1]) pq.add(new int[]{x, y, distance});
                }
            }
        }
        return moves[hole[0]][hole[1]] == null ? "impossible" : moves[hole[0]][hole[1]];
    }

    public static void main(String[] args) {
        TheMazeIII theMazeIII = new TheMazeIII();
        System.out.println(theMazeIII.findShortestWay(new int[][]{{0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}}, new int[]{4, 3}, new int[]{0, 1}));
    }
}
