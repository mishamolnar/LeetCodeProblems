package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;


//link - https://leetcode.com/problems/generate-parentheses/
public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3));
    }

    // O(n) time and constant space
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTrack(list, new StringBuilder(), n, 0);
        return list;
    }

    private void backTrack(List<String> result, StringBuilder current, int remainsToOpen, int remainsToClose) {
        if (remainsToOpen == 0 && remainsToClose == 0) {
            result.add(current.toString());
        }
        if (remainsToOpen > 0)backTrack(result, new StringBuilder(current).append('('), remainsToOpen - 1, remainsToClose + 1);
        if (remainsToClose > 0) backTrack(result, new StringBuilder(current).append(')'), remainsToOpen, remainsToClose - 1);
    }
}
