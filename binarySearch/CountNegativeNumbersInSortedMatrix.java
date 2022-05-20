package LeetCode.binarySearch;


//https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/submissions/
public class CountNegativeNumbersInSortedMatrix {

    public static void main(String[] args) {
        CountNegativeNumbersInSortedMatrix count = new CountNegativeNumbersInSortedMatrix();
        System.out.println(count.indexOfFirstNegative(new int[]{2, 1, -1, -2, -3}));
    }

    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] arr : grid) {
            count += (arr.length - indexOfFirstNegative(arr));
        }
        return count;
    }

    private int indexOfFirstNegative(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= 0) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
