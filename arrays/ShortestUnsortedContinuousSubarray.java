package LeetCode.arrays;


//https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int smallest = Integer.MAX_VALUE, swapLeft = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (smallest < nums[i])
                swapLeft = i;  //шукаємо елемент зліва, який є більшим ніж будь який елемент правіше від нього
            smallest = Math.min(nums[i], smallest);
        }
        if (swapLeft == -1) return 0;
        int biggest = Integer.MIN_VALUE, swapRight = 0;
        for (int i = 0; i < nums.length; i++) {
            if (biggest > nums[i])
                swapRight = i; //шукаємо елемент зправа, який буде меншим ніж будь який елемент лівіше від нього
            biggest = Math.max(biggest, nums[i]);
        }
        return swapRight - swapLeft + 1;
    }
}
