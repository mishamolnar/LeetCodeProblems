package LeetCode.dynamic;

import java.util.Arrays;


//link - https://leetcode.com/problems/jump-game-ii/
public class JumpGameII {
    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        System.out.println(jumpGameII.jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}));
        System.out.println(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}.length);
    }

    //O(n) time O(1) space
    public int jump(int[] nums) {
        int count = 0;
        int max = 0;
        int currentMax = 0; //
        if (nums.length == 1) return 1;
        for (int i = 0; i <= max; i++) {
            if (i + nums[i] > currentMax) {
                currentMax = nums[i] + i;
            }
            if (max == i) {
                count++;
                max = currentMax;
            }
            if (max >= nums.length - 1) return count;
        }
        return count;
    }
}
