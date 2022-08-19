package LeetCode.string;

import java.util.Arrays;

public class LongestSubstringWithLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int uniqueCount = (int) s.chars().distinct().count();
        int[] chars = new int[26];
        int max = -1;
        for (int maxAllowed = 0; maxAllowed <= uniqueCount; maxAllowed++) {
            int currentUniqueCount = 0, moreThenK = 0, left = 0, right = 0;
            Arrays.fill(chars, 0);
            while (right < s.length()) {
                int c = s.charAt(right++) - 'a';
                if (chars[c]++ == 0)
                    currentUniqueCount++;
                if (chars[c] == k)
                    moreThenK++;
                while (currentUniqueCount > maxAllowed) {
                    int removed = s.charAt(left++) - 'a';
                    if (chars[removed] == 1)
                        currentUniqueCount--;
                    if (chars[removed] == k)
                        moreThenK--;
                    chars[removed]--;
                }
                if (currentUniqueCount == maxAllowed && moreThenK == currentUniqueCount)
                    max = Math.max(right - left, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithLeastKRepeatingCharacters repeatingCharacters = new LongestSubstringWithLeastKRepeatingCharacters();
        System.out.println(repeatingCharacters.longestSubstring("aaabb", 3));
    }
}
