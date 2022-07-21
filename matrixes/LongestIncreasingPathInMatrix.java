package LeetCode.matrixes;

import java.util.Arrays;

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/submissions/
public class LongestIncreasingPathInMatrix {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res = Math.max(BFS(matrix, memo, i, j), res);
            }
        }
        return res;
    }

    private int BFS(int[][] matrix, int[][] memo, int i, int j) {
        if (memo[i][j] != 0) return memo[i][j];
        memo[i][j] = 1;
        for (int[] dir : DIRECTIONS) {
            int currI = i + dir[0];
            int currJ = j + dir[1];
            if (currI < 0 || currJ < 0
                    || currI >= matrix.length || currJ >= matrix[0].length
                    || matrix[i][j] >= matrix[currI][currJ]) continue;
            memo[i][j] = Math.max(BFS(matrix, memo, currI, currJ) + 1, memo[i][j]);
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        LongestIncreasingPathInMatrix longest = new LongestIncreasingPathInMatrix();
        System.out.println(longest.longestIncreasingPath(new int[][]{{9,9,4}, {6,6,8}, {2,1,1}}));
        System.out.println(longest.longestIncreasingPath(new int[][]{{0}}));
    }
}
