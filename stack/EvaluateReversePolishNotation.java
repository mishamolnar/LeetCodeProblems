package LeetCode.stack;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        EvaluateReversePolishNotation reversePolishNotation = new EvaluateReversePolishNotation();
        System.out.println(reversePolishNotation.evalRPN(new String[]{"2","1","+","3","*"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        HashSet<String> set = new HashSet<>(List.of("/", "+", "-", "*"));
        for (int i = 0; i < tokens.length; i++) {
            if (set.contains(tokens[i])) {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch (tokens[i]) {
                    case "/":
                        stack.push(String.valueOf(b / a));
                        break;
                    case "*":
                        stack.push(String.valueOf(b * a));
                        break;
                    case "-":
                        stack.push(String.valueOf(b - a));
                        break;
                    case "+":
                        stack.push(String.valueOf(b + a));
                        break;
                }
            } else stack.push(tokens[i]);
        }
        return Integer.valueOf(stack.pop());
    }
}
