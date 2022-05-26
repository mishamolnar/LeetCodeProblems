package LeetCode.arrays;

import java.util.Arrays;

//link - https://leetcode.com/problems/maximum-subarray/submissions/
public class MaximumSubarray {

    public int maxSubArrayTwo(int[] nums) {
        int left = 0, max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) sum = nums[i];
            else sum += nums[i];
            max = Math.max(sum, max);
        }
        return max;
    }

    // O(n) solution
    public int maxSubArray(int[] nums) {
        int maxNumber = nums[0];
        int currentNumber = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currentNumber < nums[i] && currentNumber < 0) { // не збільшувати значення, а просто замінити,
                // якщо значення негативне і ми можемо його замінити на більш вигідне
                currentNumber = nums[i];
            } else currentNumber += nums[i]; // в інакшому випадку просто інкременетимо
            maxNumber = Math.max(currentNumber, maxNumber); // перепризначаємо якщо можемо
        }
        return maxNumber;
    }

    public int maxSubArrayDivideAndConquer(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int start, int end) {
        if (start == end) return nums[start];

        int mid = (start + end) / 2;
        int sum = 0;
        int leftMaxSum = Integer.MIN_VALUE;
        for (int i = mid; i >= 0; i--) {
            sum += nums[i];
            leftMaxSum = Math.max(leftMaxSum, sum); // max sum from mid to start
        }

        sum = 0;
        int rightMaxSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= end; i++) {
            sum += nums[i];
            rightMaxSum = Math.max(rightMaxSum, sum); // max sum from mid to end
        }
        int max = Math.max(helper(nums, start, mid), helper(nums, mid + 1, end)); // check same in the first quoter
        return Math.max(max, rightMaxSum + leftMaxSum); //return max value
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArrayDivideAndConquer(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
