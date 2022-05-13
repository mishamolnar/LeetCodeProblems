package LeetCode.string;

import java.util.HashSet;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        System.out.println(palindromicSubstrings.countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += extend(s, i, i);
            result += extend(s, i, i + 1);
        }
        return result;
    }

    private int extend(String s, int start, int end) {
        int count = 0;
        for (; start>= 0 && end <= s.length() - 1; start--, end++) {
            if (s.charAt(start) != s.charAt(end)) break;
            count++;
        }
        return count;
    }
}
