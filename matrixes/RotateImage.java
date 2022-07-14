package LeetCode.matrixes;

//complexity - time O(nm) and space O(1)
// link - https://leetcode.com/problems/rotate-image/
public class RotateImage {

    public void rotateTwo(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    private void reflect(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                swap(matrix, i, j, i, matrix.length - j - 1);
            }
        }
    }

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                if (i == j) continue;
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void swap(int[][] matrix, int x, int y, int i, int j) {
        int buff = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = buff;
    }


    public void rotate(int[][] matrix) {
        for (int level = 0; level < matrix.length / 2; level++) {
            for (int st = 0; st <= matrix.length - 2 - 2 * level; st++) {
                int one = matrix[level][level + st];
                int two = matrix[matrix.length - level - 1][matrix.length - st - level - 1];
                matrix[matrix.length - level - 1][matrix.length - st - level - 1] = matrix[level + st][matrix.length - level - 1]; // 1
                matrix[level][level + st] = matrix[matrix.length - level - st - 1][level]; // 2
                matrix[level + st][matrix.length - level - 1] = one;
                matrix[matrix.length - level - st - 1][level] = two;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
//        int[][] image = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] image = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] image = new int[][]{{1, 2}, {3, 4}};
        rotateImage.rotate(image);
        System.out.println(image);
    }
}
