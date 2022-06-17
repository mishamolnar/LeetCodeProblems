package LeetCode.tree;

import java.util.*;
import java.util.stream.Collectors;


public class AutocompleteSystemII {
    private Node root;
    private Node current;
    private StringBuilder currentSentence;

    public AutocompleteSystemII(String[] sentences, int[] times) {
        root = new Node(new HashMap<>(), new HashMap<>());
        current = root;
        currentSentence = new StringBuilder();
        for (int k = 0; k < sentences.length; k++) {
            Node buff = root;
            for (int i = 0; i < sentences[k].length(); i++) {
                buff.next.putIfAbsent(sentences[k].charAt(i), new Node(new HashMap<>(), new HashMap<>()));
                buff.current.put(sentences[k], times[k]);
                buff = buff.next.get(sentences[k].charAt(i));
            }
            buff.current.put(sentences[k], times[k]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            addToSentences(currentSentence.toString());
            current = root;
            currentSentence = new StringBuilder();
            return Collections.emptyList();
        }
        currentSentence.append(c);
        current.next.putIfAbsent(c, new Node(new HashMap<>(), new HashMap<>()));
        current = current.next.get(c);
        return current.current.entrySet().stream().sorted((a, b) -> !Objects.equals(a.getValue(), b.getValue()) ? b.getValue() - a.getValue()
                : a.getKey().compareTo(b.getKey()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private void addToSentences(String sentence) {
        Node buff = root;
        for (int i = 0; i < sentence.length(); i++) {
            buff.next.putIfAbsent(sentence.charAt(i),
                    new Node(new HashMap<>(), new HashMap<>()));
            buff.current.put(sentence, buff.current.getOrDefault(sentence, 0) + 1);
            buff = buff.next.get(sentence.charAt(i));
        }
        buff.current.put(sentence, 1);
    }


    private class Node {
        private Map<String, Integer> current;
        private HashMap<Character, Node> next;

        public Node(Map<String, Integer> current, HashMap<Character, Node> next) {
            this.current = current;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        AutocompleteSystemII obj = new AutocompleteSystemII(new String[]{"i love you", "island", "iroman", "i love leetcode"}, new int[]{5, 3, 2, 2});
        obj.input('i'); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
        obj.input(' '); // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
        obj.input('a'); // return []. There are no sentences that have prefix "i a".
        obj.input('#'); // return []. The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
        obj.input('i');
        obj.input(' ');
        obj.input('a');
        System.out.println(obj.input('#'));
    }
}
