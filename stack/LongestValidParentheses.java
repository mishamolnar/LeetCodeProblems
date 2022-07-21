package LeetCode.stack;

import java.util.LinkedList;
import java.util.Stack;

//https://leetcode.com/problems/longest-valid-parentheses/submissions/
public class LongestValidParentheses {

    //two side problem
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left * 2);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }
        right = 0;
        left = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                left++;
            } else {
                right++;
            } if (left == right) {
                max = Math.max(max, left * 2);
            } else if (right > left) {
                right = 0;
                left = 0;
            }
        }
        return max;
    }


    public int longestValidParenthesesWithStack(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.add(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            } else stack.add(i);
        }
        return max;
    }
}
