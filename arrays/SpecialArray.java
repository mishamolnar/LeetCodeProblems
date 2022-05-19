package LeetCode.arrays;

import java.util.Arrays;


// - https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
public class SpecialArray {
    public static void main(String[] args) {
        SpecialArray specialArray = new SpecialArray();
        System.out.println(specialArray.specialArray(new int[]{0,4,3,0,4}));
    }


    //constant space and logarithmic time
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i <= nums.length; i++) {
            if (len - search(nums, i) == i) return i;
        }
        return -1;
    }

    private int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }


    /*
    O(N) Time
    O(N) Space
    */
    public int specialArrayBucketSort(int[] nums) {
        int numOfElements = nums.length;

        // Bucket sort Time: O(N), Space: O(N)
        // Count #occurences for each number within 0 - nums.length
        // Counts[1] = #occurences of 1
        // Counts[i] = #occurences of i
        // ...
        // while counts[counts.length - 1] store the #occurences for all numbers >= counts.length - 1
        // numOfElements is the max possible answer, so no need to count #occurences for each number >= numOfElements
        int[] counts = new int[numOfElements+1];
        for(int elem : nums) {
            if(elem >= numOfElements) { counts[numOfElements]++; }
            else { counts[elem]++; }
        }

        // Reverse order
        // Consider the index i as x, and the goal is to find when (res = current number of elements >= x) == x
        int res = 0;
        for(int i = counts.length-1; i > 0; i--) {
            res += counts[i];
            if(res == i) { return i; } // res: (number of elements in nums that are >= x)  == i: (x)
        }

        return -1;
    }

}
