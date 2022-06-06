package LeetCode.matrixes;

import java.util.ArrayDeque;
import java.util.Queue;

public class SmallestRectangleEnclosingBlackPixels {
    //O(n) where n - number of black pixels
    public int minArea(char[][] image, int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int minX = x, maxX = x;
        int minY = y, maxY = y;
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            minX = Math.min(minX, curr[0]);
            minY = Math.min(minY, curr[1]);
            maxX = Math.max(maxX, curr[0]);
            maxY = Math.max(maxY, curr[1]);
            for (int[] dir : DIRECTIONS) {
                int nextX = curr[0] + dir[0];
                int nextY = curr[1] + dir[1];
                if (nextX < 0 || nextX >= image.length || nextY < 0 || nextY >= image[0].length
                        || image[nextX][nextY] == '0') continue;
                image[nextX][nextY] = '0';
                queue.add(new int[]{nextX, nextY});
            }
        }
        int vertical = (maxY - minY + 1);
        int horizontal = (maxX - minX + 1);
        return vertical * horizontal;
    }

    public static void main(String[] args) {
        SmallestRectangleEnclosingBlackPixels smallest = new SmallestRectangleEnclosingBlackPixels();
        System.out.println(smallest.minArea(new char[][]{{'0','0','1','0'},{'0','1','1','0'},{'0','1','0','0'}}, 0, 2));
    }

    //O(mlog(n) + nlog(m)) binary search solution
    public int minAreaBinarySearch(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int left = searchColumns(image, 0, y, 0, m, true);
        int right = searchColumns(image, y + 1, n, 0, m, false);
        int top = searchRows(image, 0, x, left, right, true);
        int bottom = searchRows(image, x + 1, m, left, right, false);
        return (right - left) * (bottom - top);
    }
    private int searchColumns(char[][] image, int i, int j, int top, int bottom, boolean whiteToBlack) {
        while (i != j) {
            int k = top, mid = (i + j) / 2;
            while (k < bottom && image[k][mid] == '0') ++k;
            if (k < bottom == whiteToBlack) // k < bottom means the column mid has black pixel
                j = mid; //search the boundary in the smaller half
            else
                i = mid + 1; //search the boundary in the greater half
        }
        return i;
    }
    private int searchRows(char[][] image, int i, int j, int left, int right, boolean whiteToBlack) {
        while (i != j) {
            int k = left, mid = (i + j) / 2;
            while (k < right && image[mid][k] == '0') ++k;
            if (k < right == whiteToBlack) // k < right means the row mid has black pixel
                j = mid;
            else
                i = mid + 1;
        }
        return i;
    }
}
