package LeetCode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

// link - https://leetcode.com/problems/valid-parentheses/submissions/
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()")); //true
    }

    //O(n) space and time
    public boolean isValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') stack.push((int) s.charAt(i));
            else if (!stack.isEmpty() && (s.charAt(i) == stack.peek() + 1 || s.charAt(i) == stack.peek() + 2)) stack.pop();
            else return false;
        }
        return stack.isEmpty();
    }
}
