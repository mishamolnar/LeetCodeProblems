package LeetCode.dynamic;

import java.util.*;

//https://leetcode.com/problems/concatenated-words/
public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> dict = new HashSet<>();
        List<String> res = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length)); //n - arr length, n Log(n)

        for (String word : words) { //n ^ l3
            if (check(word, dict))
                res.add(word);
            dict.add(word);
        }
        return res;
    }

    private boolean check(String s, Set<String> dict) { // l^3 where l - length of the word
        if (dict.isEmpty()) return false;
        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true;
        for (int i = 1; i < memo.length; i++) {
            for (int j = 0; j < i; j++) {
                if (!memo[j]) continue;
                if (dict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[s.length()];
    }

    public static void main(String[] args) {
        ConcatenatedWords concatenatedWords = new ConcatenatedWords();
        System.out.println(concatenatedWords.findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
    }
}
