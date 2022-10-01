package LeetCode.matrixes;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, left = 0, bottom = n - 1, right = n - 1, counter = 1;;
        while (counter <= n * n) {
            for (int i = left; i <= right; i++) {
                if (counter > n * n) break;
                res[top][i] = counter++;
            }top++;

            for (int i = top; i <= bottom; i++) {
                if (counter > n * n) break;
                res[i][right] = counter++;
            }right--;

            for (int i = right; i >= left; i--) {
                if (counter > n * n) break;
                res[bottom][i] = counter++;
            }bottom--;

            for (int i = bottom; i >= top; i--) {
                if (counter > n * n) break;
                res[i][left] = counter++;
            } left++;
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        System.out.println(spiralMatrixII.generateMatrix(3));
    }
}
