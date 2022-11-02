package LeetCode.tree;

import java.util.List;

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
