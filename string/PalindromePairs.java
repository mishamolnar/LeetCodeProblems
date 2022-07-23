package LeetCode.string;

import java.util.*;

//
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();

        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            search(words, i, root, res);
        }

        return res;
    }

    private void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int character = word.charAt(i) - 'a';

            if (root.next[character] == null)
                root.next[character] = new TrieNode();

            if (isPalindrome(word, 0, i))
                root.list.add(index);

            root = root.next[character];
        }

        root.list.add(index);
        root.index = index;
    }

    private void search(String[] words, int i, TrieNode root, List<List<Integer>> result) {
        for (int j = 0; j < words[i].length(); j++) {
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1))
                result.add(List.of(i, root.index));

            root = root.next[words[i].charAt(j) - 'a'];
            if (root == null) return;
        }

        for (Integer j : root.list) {
            if (i == j) continue;
            result.add(List.of(i, j));
        }
    }

    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--))
                return false;
        }
        return true;
    }

    private static class TrieNode {
        TrieNode[] next;
        int index;
        List<Integer> list;
        // list will record the indices of all words satisfying the following two conditions:
        // 1. each word has a suffix represented by the current TrieNode;
        // 2. the rest of the word forms a palindrome.

        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        PalindromePairs palindromePairs = new PalindromePairs();
        System.out.println(palindromePairs.palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"}));
    }
}
