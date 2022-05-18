package LeetCode.arrays;

//https://leetcode.com/problems/find-triangular-sum-of-an-array/
public class FindTriangularSumOfArray {

    public static void main(String[] args) {
        FindTriangularSumOfArray findTriangularSumOfArray = new FindTriangularSumOfArray();
        System.out.println(findTriangularSumOfArray.triangularSum(new int[]{1,2,3,4,5}));
    }

    public int triangularSum(int[] nums) {
        int len = nums.length;
        while (len != 0) {
            for (int i = 0; i < len - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            len--;
        }
        return nums[0];
    }

}
