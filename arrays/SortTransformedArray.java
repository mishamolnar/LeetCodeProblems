package LeetCode.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/sort-transformed-array/submissions/
public class SortTransformedArray {

    //O(n) time and constant space
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] result = new int[n];
        int pointer = a > 0 ? n - 1 : 0;
        int one = 0, two = n - 1;
        while (one <= two) {
            int quad1 = quad(nums[one], a, b, c);
            int quad2 = quad(nums[two], a, b, c);
            if ((quad1 > quad2 && a > 0) || (quad1 < quad2 && a < 0)) {
                result[pointer] = quad1;
                one++;
            } else {
                result[pointer] = quad2;
                two--;
            }
            pointer = a > 0 ? pointer - 1 : pointer + 1;
        }
        return result;
    }

    private int quad(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }


    public static void main(String[] args) {
        SortTransformedArray sortTransformedArray = new SortTransformedArray();
        System.out.println(Arrays.toString(sortTransformedArray.sortTransformedArray(new int[]{-4, -2, 2, 4}, -1, 3, 5)));
    }
}
