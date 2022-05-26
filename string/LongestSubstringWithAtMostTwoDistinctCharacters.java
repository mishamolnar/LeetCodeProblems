package LeetCode.string;

//https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/submissions/
public class LongestSubstringWithAtMostTwoDistinctCharacters {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int count = 0, left = 0, max = 0;
        int[] counts = new int[70];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A';
            if (++counts[c] == 1) count++;
            while (count > 2) {
                c = s.charAt(left) - 'A';
                if (--counts[c] == 0) count--;
                left++;
            }
            max = Math.max(i - left + 1, max);
        }
        return max;
    }
}
