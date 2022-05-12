package LeetCode.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/move-zeroes/submissions/
public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(new int[]{0,1,0,3,12});
    }

    //O(n) time and no extra space
    public void moveZeroes(int[] nums) {
        int leftPointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            nums[leftPointer++] = nums[i];
        }
        Arrays.fill(nums, leftPointer, nums.length, 0);
    }
}
