package LeetCode.string;

//link - https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("abbfd"));
    }


    //O (n2) complexity  and constant space
    public String longestPalindrome(String s) {
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
