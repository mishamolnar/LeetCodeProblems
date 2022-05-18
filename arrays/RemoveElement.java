package LeetCode.arrays;

//link - https://leetcode.com/problems/remove-element/
public class RemoveElement {
    public static void main(String[] args) {

    }

    public int removeElement(int[] nums, int val) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) continue;
            nums[result++] = nums[i];
        }
        return result;
    }
}
