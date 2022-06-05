package LeetCode.tree;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/design-search-autocomplete-system/
public class AutocompleteSystem {
    private Node root;
    private StringBuilder prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Node();
        prefix = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            add(prefix.toString(), 1);
            prefix = new StringBuilder();
            return new ArrayList<>();
        }
        prefix.append(c);
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!curr.children.containsKey(prefix.charAt(i))) {
                return new ArrayList<>();
            }
            curr = curr.children.get(prefix.charAt(i));
        }
        Map<String, Integer> temp = curr.counts;
        return curr.counts.entrySet().stream()
                .sorted((a, b) -> (a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()))
                .limit(3)
                .map(a->a.getKey())
                .collect(Collectors.toList());
    }

    private void add(String sentence, int count) {
        Node curr = root;
        for (char c : sentence.toCharArray()) {
            curr.children.putIfAbsent(c, new Node());
            curr = curr.children.get(c);
            curr.counts.put(sentence, curr.counts.getOrDefault(sentence, 0) + count);
        }
    }

    private class Node{
        Map<Character, Node> children;
        Map<String, Integer> counts;

        public Node() {
            children = new HashMap<>();
            counts = new HashMap<>();
        }
    }
}
