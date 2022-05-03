package LeetCode.dynamic;

import java.util.List;

// not correct, doest not work
public class WordBreakMySolution {

    public static void main(String[] args) {
        WordBreakMySolution wordBreak = new WordBreakMySolution();
//        System.out.println(wordBreak.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));\
        System.out.println(wordBreak.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
//        System.out.println(wordBreak.wordBreak("leetcode", List.of("leet", "code")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        PrefixTrie prefixTrie = new PrefixTrie(wordDict);
        return helper(s, prefixTrie, 0, s.length() - 1);
    }

    private boolean helper(String s, PrefixTrie prefixTrie, int start, int end) {
        boolean buff = false;
        if (start > end) return false;
        if (prefixTrie.get(s, start, end)) {
            buff = helper(s, prefixTrie, end + 1, s.length() - 1);
            if (end == s.length() - 1) return true;
        }
        return helper(s, prefixTrie, start, end - 1) || buff;
    }

    private class PrefixTrie{
        Node root;

        private PrefixTrie(List<String> dictionary) {
            for (String s : dictionary) {
                addWord(s);
            }
        }

        private void addWord(String s) {
            put(s);
        }

        private void put(String key) {
            root = put(root, key, true, 0);
        }

        private Node put(Node x, String key, boolean value, int d) {
            char c = key.charAt(d);
            if (x == null) x = new Node(c);
            if (c < x.c) {
                x.left = put(x.left, key, value, d);
            } else if (c > x.c) {
                x.right = put(x.right, key, value, d);
            } else if (d < key.length() - 1) {
                x.mid = put(x.mid, key, value, d + 1);
            } else {
                x.value = value;
            }
            return x;
        }

        private boolean get(String s, int start, int end) {
            Node x = get(root, s, start, end);
            if (x == null) return false;
            return x.value;
        }

        private Node get(Node x, String s, int d, int k) {
            if (x == null) return null;
            char c = s.charAt(d);
            if (c < x.c) return get(x.left, s, d, k);
            if (c > x.c) return get(x.right, s, d, k);
            else if (d < k) return get(x.mid, s, d + 1, k);
            else return x;
        }

        private class Node {
            char c;
            private boolean value;
            private Node left;
            private Node right;
            private Node mid;

            private Node(char c) {
                this.c = c;
            }
        }
    }
}
