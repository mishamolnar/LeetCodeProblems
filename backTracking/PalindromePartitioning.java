package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    //O(n * 2^n)
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backTrack(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void backTrack(List<List<String>> res, List<String> curr, String s, int start) {
        if (start == s.length()) {
            res.add(curr);
        } else {
            for (int i = start + 1; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    curr.add(s.substring(start, i + 1));
                    backTrack(res, new ArrayList<>(curr), s, i + 1);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }

    boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}
