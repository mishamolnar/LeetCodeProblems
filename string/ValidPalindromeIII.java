package LeetCode.string;

import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/valid-palindrome-iii/
public class ValidPalindromeIII {
    private Integer[][] memo;

    //O(n^2) time and space
    public boolean isValidPalindrome(String s, int k) {
        this.memo = new Integer[s.length()][s.length()];
        return countOfCharactersToRemove(s, 0, s.length() -1) <= k;
    }

    private int countOfCharactersToRemove(String s, int left, int right) {
        if (left == right) return 0;
        if (left == right - 1) return s.charAt(left) == s.charAt(right) ? 0 : 1;

        if (this.memo[left][right] != null) return this.memo[left][right];

        if (s.charAt(left) == s.charAt(right)) {
            memo[left][right] = countOfCharactersToRemove(s, left + 1, right - 1);
            return memo[left][right];
        } else {
            memo[left][right] = 1 + Math.min(countOfCharactersToRemove(s, left + 1, right), countOfCharactersToRemove(s, left, right - 1));
            return memo[left][right];
        }
    }

    public boolean isValidPalindromeBottomUp(String s, int k) {
        int memo[][] = new int[s.length()][s.length()];

        // Generate all combinations of `i` and `j` in the correct order.
        for (int i = s.length() - 2; i >= 0; i--)
            for (int j = i + 1; j < s.length(); j++) {
                // Case 1: Character at `i` equals character at `j`
                if (s.charAt(i) == s.charAt(j))
                    memo[i][j] = memo[i + 1][j - 1];

                    // Case 2: Character at `i` does not equal character at `j`.
                    // Either delete character at `i` or delete character at `j`
                    // and try to match the two pointers using recursion.
                    // We need to take the minimum of the two results and add 1
                    // representing the cost of deletion.
                else
                    memo[i][j] = 1 + Math.min(memo[i + 1][j], memo[i][j - 1]);
            }

        // Return true if the minimum cost to create a palindrome by only deleting the letters
        // is less than or equal to `k`.
        return memo[0][s.length() - 1] <= k;
    }


    public static void main(String[] args) {
        ValidPalindromeIII validPalindromeIII = new ValidPalindromeIII();
        System.out.println(validPalindromeIII.isValidPalindrome("bacabaaa", 2));
    }
}
