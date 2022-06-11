package LeetCode.string;

//https://leetcode.com/problems/valid-palindrome-ii/submissions/
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        return helper(s, 0, s.length() - 1, true);
    }

    private boolean helper(String s, int left, int right, boolean canRemove) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (!canRemove) return false;
                else return helper(s, left + 1, right, false) || helper(s, left, right - 1, false);
            }
            left++;
            right--;
        }
        return true;
    }
}
