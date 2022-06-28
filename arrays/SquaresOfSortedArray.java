package LeetCode.arrays;

//https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int positive = 0;
        while (positive < nums.length && nums[positive] < 0) positive++;
        int negative = positive - 1;
        for (int i = 0; i < res.length; i++) {
            if (negative >= 0 &&
                    (positive >= nums.length || Math.abs(nums[negative]) < nums[positive])) res[i] = nums[negative--];
            else res[i] = nums[positive++];
            res[i] = res[i] * res[i];
        }
        return res;
    }

    public static void main(String[] args) {
        SquaresOfSortedArray squaresOfSortedArray = new SquaresOfSortedArray();
        squaresOfSortedArray.sortedSquares(new int[]{-1});
    }
}
