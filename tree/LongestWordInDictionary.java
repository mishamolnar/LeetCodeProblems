package LeetCode.tree;

import java.util.Arrays;

public class LongestWordInDictionary {
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode(true);
        for (int i = 0; i < root.next.length; i++) root.next[i] = new TrieNode(false);
        Arrays.sort(words, (a, b) -> a.length() == b.length() ? b.compareTo(a) :
                Integer.compare(a.length(), b.length()));
        String res = "";
        for (String word : words) {
            if (add(root, word)) res = word;
        }
        return res;
    }

    private boolean add(TrieNode root, String word) {
        boolean res = true;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (root.next[idx] == null) root.next[idx] = new TrieNode(false);
            res = res & root.end;
            root = root.next[idx];
        }
        root.end = true;
        return res;
    }

    private class TrieNode{
        boolean end;
        TrieNode[] next;

        public TrieNode(boolean end) {
            this.end = end;
            this.next = new TrieNode[26];
        }
    }
}
