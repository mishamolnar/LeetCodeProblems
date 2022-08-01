package LeetCode.dynamic;

import LeetCode.string.AddBoldTagInString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//https://leetcode.com/problems/stickers-to-spell-word/
public class StickersToSpellWord {

    //n 2^n
    public int minStickers(String[] stickers, String target) {
        Map<Character, Integer> t = formMap(target);
        List<Map<Character, Integer>> list = new  ArrayList<>();
        for (String sticker : stickers) {
            list.add(formMap(sticker));
        }
        HashMap<Map<Character, Integer>, Integer> memo = new HashMap<>();
        int res = dfs(t, memo, list, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(Map<Character, Integer> t, HashMap<Map<Character, Integer>, Integer> memo,
                    List<Map<Character, Integer>> dict, int count) {
        if(memo.containsKey(t))
            return memo.get(t);
        int smallest = Integer.MAX_VALUE;
        for (Map<Character, Integer> word : dict) {
            Map<Character, Integer> newT = extract(t, word);
            if (newT.equals(t)) continue;
            if (newT.isEmpty()) return count + 1;
            smallest = Math.min(smallest, dfs(newT, memo, dict, count + 1));
        }
        memo.put(t, smallest);
        return smallest;
    }

    private HashMap<Character, Integer> extract(Map<Character, Integer> target, Map<Character, Integer> word) {
        HashMap<Character, Integer> res = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            int count = entry.getValue() - word.getOrDefault(entry.getKey(), 0);
            if (count > 0) res.put(entry.getKey(), count);
        }
        return res;
    }

    private Map<Character, Integer> formMap(String s) {
        Map<Character, Integer> word = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            word.put(s.charAt(i), word.getOrDefault(s.charAt(i), 0) + 1);
        }
        return word;
    }

    public static void main(String[] args) {
        StickersToSpellWord stickersToSpellWord = new StickersToSpellWord();
        System.out.println(stickersToSpellWord.minStickers(new String[]{"with","example","science"}, "thehatz"));
    }
}
