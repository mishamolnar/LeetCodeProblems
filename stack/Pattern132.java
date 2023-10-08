package LeetCode.stack;

import java.util.Stack;

public class Pattern132 {
        public boolean find132pattern(int[] nums) {
            //iterate from right to left
            //if big number occurs pop from the stack and assign to second poppped values
            //if medium occurs - the add to stack
            //if smallest = then compare with second and return true
            Stack<Integer> stack = new Stack<>();
            int second = Integer.MIN_VALUE;
            for (int i = nums.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && nums[i] > stack.peek())
                    second = stack.pop();
                stack.add(nums[i]);
                if (second > nums[i]) return true;
            }
            return false;
        }
}
