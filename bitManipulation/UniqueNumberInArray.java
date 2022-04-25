package LeetCode.bitManipulation;

// link - https://leetcode.com/problems/single-number/
// why does it work
// for example array = [4, 2, 1, 1, 2] r = 0
// r ^ 4 = 0 0 0 0 ^ 0 1 0 0 = 0 1 0 0
// r ^ 2 = 0 1 0 0 ^ 0 0 1 0 = 0 1 1 0
// r ^ 1 = 0 1 1 0 ^ 0 0 0 1 = 0 1 1 1
// r ^ 1 = 0 1 1 1 ^ 0 0 0 1 = 0 1 1 0
// r ^ 2 = 0 1 1 0 ^ 0 0 1 0 = 0 1 0 0
public class UniqueNumberInArray {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (Integer i : nums) {
            result = result^i;
        }
        return result;
    }
}
