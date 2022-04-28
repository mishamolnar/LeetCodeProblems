package LeetCode.string;

import LeetCode.dynamic.LongestCommonSubsequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
// time - O(n)
// space O(1) because hashmap contains only alphabet chars (26 max)
// sliding window problem
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0; //max value of all time
        int start = 0; //start of current sequence with current element i, that contains no duplicates

        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (hashMap.containsKey(current)) {
                start = Math.max(start, hashMap.get(current) + 1); // if we found char duplicate char - we need to check if current sequence contains this char, if yes - set start to next char (regard to current)
            }
            hashMap.put(current, i);
            max = Math.max(max, i - start + 1); //maybe we need to update max value
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        lswrc.lengthOfLongestSubstring("pwwkew");
    }
}
