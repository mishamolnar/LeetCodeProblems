package LeetCode.matrixes;

import java.util.Arrays;

//https://leetcode.com/problems/set-matrix-zeroes/solution/
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        boolean zeroFirstRow = false;
        boolean zeroFirstCol = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) zeroFirstRow = true;
                    if (j == 0) zeroFirstCol = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (zeroFirstRow) Arrays.fill(matrix[0], 0);
        if (zeroFirstCol) {
            for (int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
        }
    }


    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setZeroes(new int[][]{{1, 1, 1},{1,0,1},{1,1,1}});
    }
}
