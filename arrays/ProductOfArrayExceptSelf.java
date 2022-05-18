package LeetCode.arrays;


import java.util.Arrays;

//link - https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        productOfArrayExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4});
    }

    // O(n) - time and O(1) space
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        //left sums counting
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        //total sum counting
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }

}
