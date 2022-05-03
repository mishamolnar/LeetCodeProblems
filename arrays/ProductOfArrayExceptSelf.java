package LeetCode.arrays;


//link - https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {

    // O(n) - time and O(1) space
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1]; //prefixes calculation
        }
        int postfix = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = result[i] * postfix;
            postfix *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        productOfArrayExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4});
    }


}
