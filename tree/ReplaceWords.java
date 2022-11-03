package LeetCode.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for (String s : dictionary) {
            add(root, s);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : sentence.split(" ")) {
            sb.append(getMinimum(root, s)).append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public int longestPalindrome(String[] words) {
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (set.contains(reversed)) {
                set.remove(word);
                set.remove(reversed);
                res.add(word);
                res.add(reversed);
            } else set.add(word);
        }
        return res.size() * 2 + (set.stream().anyMatch((a) -> a.charAt(0) == a.charAt(1)) ? 2 : 0);
    }

    private String getMinimum(TrieNode root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (root.next[ch] == null) return word;
            root = root.next[ch];
            if (root.end) return word.substring(0, i + 1);
        }
        return word;
    }

    private void add(TrieNode root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (root.next[ch] == null) root.next[ch] = new TrieNode();
            root = root.next[ch];
        }
        root.end = true;
    }

    private class TrieNode{
        boolean end;
        TrieNode[] next;

        public TrieNode() {
            this.end = false;
            this.next = new TrieNode[26];
        }
    }
}
