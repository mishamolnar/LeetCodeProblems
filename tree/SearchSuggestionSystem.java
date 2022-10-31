package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode('.');
        for (String product : products) {
            add(product, 0, root);
        }
        if (root.next[searchWord.charAt(0) - 'a'] == null)
            root.next[searchWord.charAt(0) - 'a'] = new TrieNode(searchWord.charAt(0));
        TrieNode iterator = root.next[searchWord.charAt(0) - 'a'];
        List<List<String>> res = new ArrayList<>();
        for (int i = 1; i < searchWord.length(); i++) {
            iterator.words.sort(String::compareTo);
            res.add(iterator.words.subList(0, Math.min(3, iterator.words.size())));
            if (iterator.next[searchWord.charAt(i) - 'a'] == null)
                iterator.next[searchWord.charAt(i) - 'a'] = new TrieNode(searchWord.charAt(i));
            iterator = iterator.next[searchWord.charAt(i) - 'a'];
        }
        return res;
    }

    private void add(String s, int index, TrieNode curr) {
        if (index == s.length()) return;
        curr.words.add(s);
        if (curr.next[s.charAt(index) - 'a'] == null)
            curr.next[s.charAt(index) - 'a'] = new TrieNode(s.charAt(index));
        add(s, index + 1, curr.next[s.charAt(index) - 'a']);
    }

    private class TrieNode{
        List<String> words;
        TrieNode[] next;
        char c;

        public TrieNode(char c) {
            this.words = new ArrayList<>();
            this.c = c;
            this.next = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        SearchSuggestionSystem suggestionSystem = new SearchSuggestionSystem();
        System.out.println(suggestionSystem.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
    }
}
