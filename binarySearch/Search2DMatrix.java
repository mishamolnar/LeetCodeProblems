package LeetCode.binarySearch;

//https://leetcode.com/problems/search-a-2d-matrix/submissions/
public class Search2DMatrix {

    public static void main(String[] args) {
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        System.out.println(search2DMatrix.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, bottom = 0, right = matrix[0].length, top = matrix.length - 1;
        int row = -1;
        while (bottom <= top) {
            int mid = bottom + (top - bottom) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length - 1]) {
                row = mid;
                break;
            }
            else if (target < matrix[mid][0]) top = mid - 1;
            else bottom = mid  + 1;
        }
        if (row == -1) return false;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) return true;
            else if (matrix[row][mid] > target) right = mid - 1;
            else left = mid  + 1;
        }
        return false;
    }
}
