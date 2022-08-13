package LeetCode.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//https://leetcode.com/problems/word-break-ii/submissions/
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<StringBuilder>> indexToWords = new HashMap<>();
        List<StringBuilder> list = new ArrayList<>();
        list.add(new StringBuilder());
        indexToWords.put(0, list);
        for (int i = 0; i < s.length(); i++) {
            if (!indexToWords.containsKey(i)) continue;
            for (String dict : wordDict) {
                if (i + dict.length() <= s.length() && s.substring(i, i + dict.length()).equals(dict)) {
                    List<StringBuilder> results = new ArrayList<>(indexToWords.get(i));
                    List<StringBuilder> curr = new ArrayList<>();
                    for (StringBuilder result : results) {
                        curr.add(new StringBuilder(result).append(dict).append(" "));
                    }
                    if (indexToWords.containsKey(i + dict.length()))
                        curr.addAll(indexToWords.get(i + dict.length()));
                    indexToWords.put(i + dict.length(), curr);
                }
            }
        }
        return indexToWords.getOrDefault(s.length(), new ArrayList<>())
                .stream()
                .filter(stringBuilder -> s.length() > 0)
                .map(stringBuilder -> stringBuilder.toString().trim())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        WordBreakII wordBreakII = new WordBreakII();
        System.out.println(wordBreakII.wordBreak("catsandog", List.of("cat","cats","and","sand","dog")));
    }
}
