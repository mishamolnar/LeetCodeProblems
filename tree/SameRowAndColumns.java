package LeetCode.tree;

import java.util.HashMap;
import java.util.Map;

public class SameRowAndColumns {
    public int equalPairs(int[][] grid) {
        Trie trie = new Trie();
        for (int[] row : grid) {
            trie.add(row);
        }

        int count = 0;
        for (int i = 0; i < grid[0].length; i++) {
            TrieNode iterator = trie.root;
            for (int j = 0; j < grid.length; j++) {
                iterator = iterator.children.getOrDefault(grid[j][i], new TrieNode());
            }
            count += iterator.count;
        }
        return count;
    }


    private static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void add(int[] row) {
            TrieNode iterator = root;
            for (int num : row) {
                iterator.count++;
                iterator.children.putIfAbsent(num, new TrieNode());
                iterator = iterator.children.get(num);
            }
            iterator.count++;
        }
    }

    private static class TrieNode {
        int count;
        Map<Integer, TrieNode> children;

        TrieNode() {
            count = 0;
            children = new HashMap<>();
        }
    }
}
