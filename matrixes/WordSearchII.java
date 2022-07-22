package LeetCode.matrixes;

import java.util.*;

//https://leetcode.com/problems/word-search-ii/
public class WordSearchII {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    Node root = new Node('!', false);

    //O(MN 3^MN)
    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            put(word, 0, root);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (!root.map.containsKey(c)) continue;
                DFS(board, root.map.get(c), result,
                        new StringBuilder(String.valueOf(c)), i, j);
            }
        }
        return result;
    }

    private void DFS(char[][] board, Node node, List<String> result, StringBuilder curr, int i, int j) {
        if (node.end) {
            result.add(curr.toString());
            node.end = false;
        }
        char buff = board[i][j];
        board[i][j] = '!';
        for (int[] dir : DIRECTIONS) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI < 0 || newJ < 0 || newI >= board.length
                    || newJ >= board[0].length || !node.map.containsKey(board[newI][newJ])) continue;
            curr.append(board[newI][newJ]);
            DFS(board, node.map.get(board[newI][newJ]), result, curr, newI, newJ);
            curr.deleteCharAt(curr.length() - 1);
        }
        board[i][j] = buff;
    }

    private void put(String s, int pointer, Node node) {
        char c = s.charAt(pointer);
        node.map.putIfAbsent(c, new Node(c, false));
        node = node.map.get(c);
        if (pointer == s.length() - 1) node.end = true;
        else put(s, pointer + 1, node);
    }


    private static class Node {
        char c;
        boolean end;
        Map<Character, Node> map;


        public Node(char c, boolean end) {
            this.c = c;
            this.end = end;
            map = new HashMap<>();
        }
    }


    public static void main(String[] args) {
        WordSearchII wordSearchII = new WordSearchII();
        System.out.println(wordSearchII.findWords(new char[][]{{'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}}, new String[]{"oath","pea","eat","rain"}));
    }
}
