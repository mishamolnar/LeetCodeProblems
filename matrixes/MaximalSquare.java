package LeetCode.matrixes;

import java.util.Arrays;

//https://leetcode.com/problems/maximal-square/submissions/
public class MaximalSquare {

    //O(MN) complexity and O(n) space
    public int maximalSquare(char[][] matrix) {
        int[] prev = new int[matrix[0].length + 1];
        int[] curr = new int[matrix[0].length + 1];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int buff = Math.min(prev[j], Math.min(curr[j], prev[j + 1])) + 1;
                    res = Math.max(res, buff);
                    curr[j + 1] = buff;
                }
            }
            System.arraycopy(curr, 0, prev, 0, prev.length);
            Arrays.fill(curr, 0);
        }
        return res * res;
    }


    //constant memory but works only till 65025
    public int maximalSquareChars(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                int left = j > 0 ? matrix[i][j - 1] : 0;
                int top = (i == 0) ? 0 :
                        j > 0 ? matrix[i - 1][j] - matrix[i - 1][j - 1]
                                : matrix[i - 1][j];
                matrix[i][j] -= '0';
                matrix[i][j] += (top + left);
            }
        }
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = calculateBiggestSquare(matrix, i, j, res);
            }
        }
        return res * res;
    }

    private int calculateBiggestSquare(char[][] matrix, int i, int j, int res) {
        int max = res;
        for (int k = res + 1; k <= Math.min(i, j) + 1; k++) {
            if (matrix[i][j]
                    - (k > i ? 0 : matrix[i - k][j] )
                    - (k > j ? 0 : matrix[i][j - k] )
                    + (k > j || k > i ? 0 : matrix[i - k][j - k]) < k * k) break;
            else max = k;
        }
        return max;
    }


    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        System.out.println(maximalSquare.maximalSquare(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}}));
        System.out.println(maximalSquare.maximalSquare(new char[][]{{'0', '1'}}));
    }
}
