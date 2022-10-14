package LeetCode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//https://leetcode.com/problems/remove-k-digits/
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        if (k == num.length())
            return "0";
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && k > 0 && stack.peekFirst() > num.charAt(i)) {
                stack.pollFirst();
                k--;
            }
            stack.addFirst(num.charAt(i));
        }

        while (k > 0) {
            stack.pollFirst();
            k--;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == 0)
            sb.deleteCharAt(0);
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        System.out.println(removeKDigits.removeKdigits("1567222", 3));
    }

}
