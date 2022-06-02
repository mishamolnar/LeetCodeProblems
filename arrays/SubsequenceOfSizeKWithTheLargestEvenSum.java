package LeetCode.arrays;

import java.sql.Timestamp;
import java.util.Arrays;

//https://leetcode.com/problems/subsequence-of-size-k-with-the-largest-even-sum/
public class SubsequenceOfSizeKWithTheLargestEvenSum {

    //NlogN time and O(N) space
    public long largestEvenSum(int[] nums, int k) {
        Arrays.sort(nums);
        int maxOdd = -1, maxEven = -1, minOdd = -1, minEven = -1;
        long result = -1, total = 0;
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            total += nums[i];
            if (nums[i] % 2 == 0) minEven = nums[i];
            else minOdd = nums[i];
        }
        if (total % 2 == 0) return total;
        for (int i = 0; i < nums.length - k; i++) {
            if (nums[i] % 2 == 0) maxEven = nums[i];
            else maxOdd = nums[i];
        }
        if (maxOdd != -1 && minEven != - 1) result = Math.max(result, total - minEven + maxOdd);
        if (maxEven != -1 && minOdd != -1) result = Math.max(result, total - minOdd + maxEven);
        return result;
    }

    public static void main(String[] args) {
        SubsequenceOfSizeKWithTheLargestEvenSum subsequenceOfSizeKWithTheLargestEvenSum = new SubsequenceOfSizeKWithTheLargestEvenSum();
        System.out.println(subsequenceOfSizeKWithTheLargestEvenSum.largestEvenSum(new int[]{3, 7, 5, 9}, 3));
    }
}
