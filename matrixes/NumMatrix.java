package LeetCode.matrixes;

//https://leetcode.com/problems/range-sum-query-2d-immutable/
public class NumMatrix {
    private int[][] matrix;

    //O(mn) for initialization and O(1) for sum region
    public NumMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j != 0) matrix[i][j] += matrix[i][j - 1];
                if (i != 0) matrix[i][j] += j > 0 ? matrix[i - 1][j] - matrix[i - 1][j - 1] : matrix[i - 1][j];
            }
        }
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrix[row2][col2] + (row1 == 0 || col1 == 0 ? 0 : matrix[row1 - 1][col1 - 1])
                - (row1 > 0 ? matrix[row1 - 1][col2] : 0) - (col1 > 0 ? matrix[row2][col1 - 1] : 0);
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // return 8 (i.e sum of the red rectangle)
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // return 11 (i.e sum of the green rectangle)
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // return 12 (i.e sum of the blue rectangle)
    }
}
