package LeetCode.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

// link - https://leetcode.com/problems/next-greater-element-ii/
public class NextGreaterElementII {
    public static void main(String[] args) {
        NextGreaterElementII nextGreaterElementII = new NextGreaterElementII();
        System.out.println(Arrays.toString(nextGreaterElementII.nextGreaterElements(new int[]{1,2,3,4,3})));
    }

    //O(n) space and time for circular
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % (nums.length)]) {
                result[stack.pop()] = nums[i % (nums.length)];
            }
            stack.push(i % (nums.length));
        }
        return result;
    }

    //for single pass
    public int[] nextGreaterElement(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }
}
