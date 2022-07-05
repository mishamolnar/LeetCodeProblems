package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return Collections.emptyList();
        List<String> result = new ArrayList<>();
        String[] board = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(result, digits, new StringBuilder(), 0, board);
        return result;
    }

    private void backtrack(List<String> result, String digits, StringBuilder curr, int pointer, String[] board) {
        if (pointer == digits.length()) result.add(curr.toString());
        else {
            String button = board[digits.charAt(pointer) - '2'];
            for (int i = 0; i < button.length(); i++) {
                curr.append(button.charAt(i));
                backtrack(result, digits, new StringBuilder(curr), pointer + 1, board);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }
}
