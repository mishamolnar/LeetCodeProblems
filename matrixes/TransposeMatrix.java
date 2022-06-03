package LeetCode.matrixes;

import java.util.Arrays;

//https://leetcode.com/problems/transpose-matrix/submissions/
public class TransposeMatrix {

    //O(nm) space and time
    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    private void swap(int[][] matrix, int x, int y, int i, int j) {
        int buff = matrix[x][y];
        matrix[x][y] = matrix[i][j];
        matrix[i][j] = buff;
    }

    public static void main(String[] args) {
        TransposeMatrix transposeMatrix = new TransposeMatrix();
        System.out.println(Arrays.deepToString(transposeMatrix.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }
}
