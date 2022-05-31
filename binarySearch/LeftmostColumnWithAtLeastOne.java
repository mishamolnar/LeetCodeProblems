package LeetCode.binarySearch;

import java.util.List;

//https://leetcode.com/problems/leftmost-column-with-at-least-a-one/solution/
public class LeftmostColumnWithAtLeastOne {

    //Let NN be the number of rows, and MM be the number of columns
    //Time complexity : O(NlogM)
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int width = dimensions.get(1), height = dimensions.get(0);
        int leftMost = Integer.MAX_VALUE;
        for (int i = 0; i < height; i++) {
            leftMost = Math.min(binarySearch(i, width, binaryMatrix), leftMost);
        }
        return leftMost != Integer.MAX_VALUE ? leftMost : -1;
    }

    private int binarySearch(int row, int width, BinaryMatrix binaryMatrix){
        int left = 0, right = width;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < width && binaryMatrix.get(row, mid) == 0) left = mid + 1;
            else right = mid - 1;
        }
        return left < width ? left : Integer.MAX_VALUE;
    }

    //O(m + n) solution
    //починаємо з правого верхнього кута і йдемо вправо
    //якщо одиничка - йдемо вправо, якщо нулик - вниз
    public int leftMostColumnWithOneFromTopRight(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);

        // Set pointers to the top-right corner.
        int currentRow = 0;
        int currentCol = cols - 1;

        // Repeat the search until it goes off the grid.
        while (currentRow < rows && currentCol >= 0) {
            if (binaryMatrix.get(currentRow, currentCol) == 0) {
                currentRow++;
            } else {
                currentCol--;
            }
        }

        // If we never left the last column, this is because it was all 0's.
        return (currentCol == cols - 1) ? -1 : currentCol + 1;
    }

    interface BinaryMatrix {
      public int get(int row, int col);
      public List<Integer> dimensions();
     }
}
