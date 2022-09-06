package LeetCode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Stack;

//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/submissions/
public class MinimumRemoveToMakeValidParenthesis {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(Character.isAlphabetic(ch))
                continue;
            if(ch == '(')
                stack.push(i);
            else {
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(')
                    stack.pop();
                else stack.push(i);
            }
        }

        StringBuilder result = new StringBuilder();
        HashSet<Integer> set = new HashSet<>(stack);
        for(int i=0;i<s.length();i++)
            if(!set.contains(i))
                result.append(s.charAt(i));

        return result.toString();
    }

    public static void main(String[] args) {
        MinimumRemoveToMakeValidParenthesis minimum = new MinimumRemoveToMakeValidParenthesis();
        System.out.println(minimum.minRemoveToMakeValid("a(b(c)d)"));
    }

}
