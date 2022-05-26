package LeetCode.dynamic;

import java.util.HashMap;
import java.util.HashSet;

// link https://leetcode.com/problems/house-robber/
public class HouseRobber {


    public int rob(int[] nums) {
        int prevOne = nums[0];
        int prevTwo = 0;
        for (int i = 1; i < nums.length; i++) {
            int buff = prevOne;
            prevOne = Math.max(prevOne, prevTwo + nums[i]);
            prevTwo = buff;
        }
        return Math.max(prevTwo, prevOne);
    }


    // step 1 naive recursion / top-down
    //time - 2^n where n is size of arr, O(1) space
    public int robSimpleRecursion(int[] nums) {
        return helperForSimpleRecursion(nums.length - 1, nums);
    }

    private int helperForSimpleRecursion(int current, int[] nums) {
        if (current < 0) return 0;
        return Math.max(helperForSimpleRecursion(current - 1, nums), nums[current] + helperForSimpleRecursion(current - 2, nums));
    }

    // step 2 - recursive + memo / top-down
    // O(n) - space and complexity
    public int robRecursiveAndMemo(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        return helperRecursiveAndMemo(nums.length - 1, memo, nums);
    }

    public int helperRecursiveAndMemo(int current, Integer[] memo, int[] nums) {
        if (current < 0) return 0;
        if (memo[current] != null) return memo[current];
        memo[current] = Math.max(helperRecursiveAndMemo(current - 1, memo, nums), nums[current] + helperRecursiveAndMemo(current - 2, memo, nums));
        return memo[current];
    }

    //step 3 - iterative + memo / bottom - up
    // O(n) - space and complexity
    public int robIterativeAndMemo(int[] nums) {
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0]; //memo 1 step ahead compared to nums
        for (int i = 2; i <= nums.length; i++) {
            memo[i] = Math.max(memo[i - 1], memo[i - 2] + nums[i - 1]);
        }
        return memo[nums.length];
    }

    //step 4 - iterative without memo
    // O(n) -  complexity and O(1) space
    // 2,7,9,3,1,5,6
    // prevOne завжди більший або однаковий
    public int robIterativeNoMemo(int[] nums) {
        int prevOne = 0;
        int prevTwo = 0;
        for (int num : nums) {
            int tmp = prevOne;
            prevOne = Math.max(prevTwo + num, prevOne);
            prevTwo = tmp;
        }
        return prevOne;
    }


    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.robIterativeNoMemo(new int[]{2,7,9,3,1,5,6}));
    }
}
