package LeetCode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


//https://leetcode.com/problems/132-pattern/submissions/
public class OneThreeTwoPattern {

    //i < j < k
    //nums[i] < nums[k] < nums[j]
    // ak - nums[k]
    //time and space - O(n)
    public boolean find132pattern(int[] nums) {
        int ak = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < ak) return true; // якщо ak більший за аі  то ми знайшли патерн
            while (!stack.isEmpty() && stack.peek() < nums[i])
                ak = stack.pop(); //aj - завжди в стекові і завжди більший за аі
            stack.push(nums[i]);
        }
        return false;
    }

//    Deque<Integer> stack = new ArrayDeque<>(); // max stack
//    int ak = Integer.MIN_VALUE;                // we want to find a seq ai < ak < aj
//
//    for (int i = nums.length - 1; i >= 0; --i) {
//        if (nums[i] < ak) // ai < ak, we're done because ai must also smaller than aj
//            return true;
//        while (!stack.isEmpty() && stack.peek() < nums[i])
//            ak = stack.pop();
//        stack.push(nums[i]); // nums[i] is a candidate of aj
//    }
//
//    return false;

    public static void main(String[] args) {

    }
}
