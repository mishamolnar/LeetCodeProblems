package LeetCode.stack;

import java.util.PriorityQueue;
import java.util.Stack;

public class MaximumWidthRamp {
    public int maxWidthRamp(int[] nums) {
        int res = 0, len = nums.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (st.isEmpty() || st.peek() > nums[i])
                st.add(i);
        }
        for (int i = len - 1; i >= 0; i--) {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                res = Math.max(res, i - st.pop());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumWidthRamp maximumWidthRamp = new MaximumWidthRamp();
        System.out.println(maximumWidthRamp.maxWidthRamp(new int[]{6,0,8,2,1,5}));
    }
}
