package LeetCode.graph;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/word-ladder/
public class WordLadder {

    //O(nm) n - beginWord.length, m - length of wordList
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Map<String, Set<String>> G = createGraph(wordList);
        Queue<String> q = new ArrayDeque<>();
        for (String pattern : getPatterns(beginWord)) {
            if (G.containsKey(pattern)) q.add(pattern);
        }
        int steps = 1;
        Set<String> target = getPatterns(endWord);
        Set<String> visited = new HashSet<>(q);
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                String pattern = q.poll();
                if (target.contains(pattern)) return steps;
                List<String> patterns = G.getOrDefault(pattern, Collections.emptySet())
                        .stream()
                        .flatMap(s -> getPatterns(s).stream())
                        .filter(s -> !visited.contains(s))
                        .collect(Collectors.toList());
                q.addAll(patterns);
                visited.addAll(patterns);
            }
            steps++;
        }
        return 0;
    }

    private Map<String, Set<String>> createGraph(List<String> wordList) {
        Map<String, Set<String>> res = new HashMap<>();
        for (String s : wordList) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = '*';
                String pattern = new String(arr);
                if (res.containsKey(pattern)) res.get(pattern).add(s);
                else {
                    Set<String> set = new HashSet<>();
                    set.add(s);
                    res.put(pattern, set);
                }
                arr[i] = s.charAt(i);
            }
        }
        return res;
    }

    private Set<String> getPatterns(String s) {
        char[] arr = s.toCharArray();
        Set<String> res = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = '*';
            res.add(new String(arr));
            arr[i] = s.charAt(i);
        }
        return res;
    }
}
