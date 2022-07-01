package LeetCode.matrixes;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

//https://leetcode.com/problems/01-matrix/
public class OneZeroMatrix {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};


    //BFS O(nm) space and time
    public int[][] updateMatrixBFS(int[][] mat) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int steps = 0;
        while (!q.isEmpty()) {
            steps++;
            for (int i = q.size(); i > 0; i--) {
                int[] curr = q.poll();
                for (int[] dir : DIRECTIONS) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x < 0 || y < 0 || x >= mat.length || y >= mat[0].length || visited[x][y]) continue;
                    mat[x][y] = steps;
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
            if (q.isEmpty()) break;
        }
        return mat;
    }


    //dynamic programming
    // O(mn) and space - O(1)
    public int[][] updateMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) continue;
                mat[i][j] = Math.min(i > 0 ? mat[i - 1][j] : 12000,
                                    j > 0 ? mat[i][j - 1] : 12000) + 1;
            }
        }
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (mat[i][j] == 0) continue;
                int buff = Math.min(i == mat.length - 1 ? 12000 : mat[i + 1][j],
                                    j == mat[0].length - 1 ? 12000 : mat[i][j + 1]) + 1;
                mat[i][j] = Math.min(buff, mat[i][j]);
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        OneZeroMatrix oneZeroMatrix = new OneZeroMatrix();
        System.out.println(Arrays.deepToString(oneZeroMatrix.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})));
    }
}
