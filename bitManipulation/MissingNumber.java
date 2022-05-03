package LeetCode.bitManipulation;


// link - https://leetcode.com/problems/missing-number/
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            ans ^= i ^ nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(new int[]{0, 2, 3, 4, 5})); // return 1
        System.out.println(missingNumber.missingNumber(new int[]{0, 1, 3, 4, 5})); // return 2
    }
}
