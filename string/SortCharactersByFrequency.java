package LeetCode.string;

import java.util.HashMap;
import java.util.Map;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map.entrySet()
                .stream()
                .sorted((a, b) -> - Integer.compare(a.getValue(), b.getValue()))
                .map(entry -> String.valueOf(entry.getKey()).repeat(entry.getValue()))
                .map(StringBuilder::new)
                .reduce(StringBuilder::append).get().toString();
    }
}
