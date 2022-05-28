package LeetCode.string;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/word-pattern-ii/submissions/
public class WordPatternII {
    private boolean matches = false;

    // time - O(n!)
    // space - O(n)
    public boolean wordPatternMatch(String pattern, String s) {
        HashMap<Character, String> dictionary = new HashMap<>();
        HashMap<String, Character> reverse = new HashMap<>();
        backTrack(pattern, s, dictionary, reverse, 0);
        return matches;
    }

    private void backTrack(String pattern, String s, HashMap<Character, String> dictionary, HashMap<String, Character> reverse, int curr) {
        if (isMatches(pattern, s, dictionary)) {
            matches = true;
        } else if (curr < s.length()) {
            for (int i = 0; i < pattern.length(); i++) {
                if (dictionary.containsKey(pattern.charAt(i))) continue;
                for (int j = curr + 1; j <= s.length(); j++) {
                    if (reverse.containsKey(s.substring(curr, j))) continue;
                    dictionary.put(pattern.charAt(i), s.substring(curr, j));
                    reverse.put(s.substring(curr, j), pattern.charAt(i));
                    backTrack(pattern, s, new HashMap<>(dictionary), new HashMap<>(reverse), j);
                }
            }
        }
    }

    private boolean isMatches(String pattern, String s, HashMap<Character, String> dictionary) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            stringBuilder.append(dictionary.get(pattern.charAt(i)));
        }
        return stringBuilder.toString().equals(s);
    }

    public static void main(String[] args) {
        WordPatternII wordPatternII = new WordPatternII();
        System.out.println(wordPatternII.wordPatternMatch("abab", "redblueredblue"));
        System.out.println("abc".substring(2));
    }
}
