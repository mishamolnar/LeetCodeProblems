package LeetCode.backTracking;

import java.util.*;

//https://leetcode.com/problems/synonymous-sentences/
public class SynonymousSentences {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> synonym : synonyms) {
            connect(map, synonym.get(0), synonym.get(1));
            connect(map, synonym.get(1), synonym.get(0));
        }
        TreeSet<String> ans = new TreeSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(text);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            ans.add(curr);
            String[] words = curr.split("\\s");
            for (int i = 0; i < words.length; i++) {
                if (map.get(words[i]) == null) continue;
                for (String s : map.get(words[i])) {
                    words[i] = s;
                    String newText = String.join(" ", words);
                    if (!ans.contains(newText)) queue.add(newText);
                }
            }
        }
        return new ArrayList<>(ans);
    }

    void connect(Map<String, List<String>> graph, String v1, String v2) {
        graph.putIfAbsent(v1, new LinkedList<>());
        graph.get(v1).add(v2);
    }
}
