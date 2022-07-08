package LeetCode.tree;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/design-add-and-search-words-data-structure/submissions/
public class WordDictionary {
    private Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node pointer = root;
        for (int i = 0; i < word.length(); i++) {
            pointer.children.putIfAbsent(word.charAt(i), new Node());
            pointer = pointer.children.get(word.charAt(i));
        }
        pointer.isEnd = true;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Node node, String word, int start) {
        Node pointer = node;
        for (int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                boolean res = false;
                for (Node child : pointer.children.values()) {
                    res |= search(child, word, i + 1);
                }
                return res;
            }
            if (!pointer.children.containsKey(c)) return false;
            pointer = pointer.children.get(c);
        }
        return pointer.isEnd;
    }

    private class Node{
        boolean isEnd = false;
        Map<Character, Node> children = new HashMap<>();

        public Node() {
        }
    }
}
