package LeetCode.arrays;

import java.util.Random;

public class ShuffleAnArray {
    private int[] nums;
    private int[] res;
    private Random random = new Random();

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        this.res = nums;
    }

    public int[] reset() {
        System.arraycopy(nums, 0, res, 0, nums.length);
        return res;
    }

    public int[] shuffle() {
        for (int i = 0; i < res.length; i++) {
            swap(nums, getRandom(i, res.length), i);
        }
        return res;
    }

    private void swap(int[] nums, int x, int y) {
        int buff = nums[x];
        nums[x] = nums[y];
        nums[y] = buff;
    }

    private int getRandom(int min, int max) {
        return this.random.nextInt(max - min) + min;
    }
}
