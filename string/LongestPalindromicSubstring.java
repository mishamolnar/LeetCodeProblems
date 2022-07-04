package LeetCode.string;

//link - https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            int[] single = palindrome(s, i, i);
            if (single[1] - single[0] + 1 > longest.length())
                longest = s.substring(single[0], single[1] + 1);
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                int[] res = palindrome(s, i, i + 1);
                if (res[1] - res[0] + 1 > longest.length())
                    longest = s.substring(res[0], res[1] + 1);
            }
        }
        return longest;
    }

    private int[] palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        l++;
        r--;
        return new int[] {l, r};
    }


    //O (n2) complexity  and constant space
    public String longestPalindromeTwo(String s) {
        int start = 0; int max = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            int oddLength = extend(s, i, i);
            int evenLength = extend(s, i, i + 1);
            if (max < Math.max(oddLength, evenLength)) {
                start = oddLength > evenLength ? (i - oddLength / 2) : (i - evenLength / 2 + 1);
                max = Math.max(oddLength, evenLength);
            }
        }
        return s.substring(start, start + max);
    }

    private int extend(String s, int start, int end) {
        for (; start >= 0 && end <= s.length() - 1 ; start--, end++) {
            if (s.charAt(start) != s.charAt(end)) break;
        }
        return end - start - 2 + 1;
    }
}
