package LeetCode.matrixes;

public class ImageOverlap {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int max = 0;
        for (int i = -n + 1; i < n; i++) {
            for (int j =-n + 1; j < n; j++) {
                max = Math.max(max, overlapCount(img1, img2, i, j));
            }
        }
        return max;
    }

    private int overlapCount(int[][] img1, int[][] img2, int x, int y) {
        int res = 0;
        for (int i = 0; i < img1.length; i++) {
            for (int j = 0; j < img1.length; j++)  {
            res += overlaps(img1, i + x, j + y, img2, i, j) ? 1 : 0;
            }
        }
        return res;
    }


    private boolean overlaps(int[][] img1, int x, int y, int[][] img2, int i, int j) {
        int n = img1.length;
        if (x < 0 || x >= n || y < 0 || y >= n || i < 0 || i >= n || j < 0 || j >= n)
            return false;
        return img1[x][y] == img2[i][j];
    }
}
