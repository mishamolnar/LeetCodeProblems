package LeetCode.matrixes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/word-search/
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, "ABCESEEEFS"));
    }


    //space is O(L) where L is the length of the word; and time is O(M * N * 3^L) where M*N is the size of the board and we have 4^L for each cell because of the recursion
    public boolean exist(char[][] board, String word) {
        Map<Character, List<int[]>> starts = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                starts.putIfAbsent(board[i][j], new ArrayList<>());
                starts.get(board[i][j]).add(new int[]{i, j});
            }
        }
        if (!starts.containsKey(word.charAt(0))) return false;
        for (int[] ints : starts.get(word.charAt(0))) {
            if (dfs(board, word, ints, 1, new boolean[board.length][board[0].length])) return true;
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int[] current, int next, boolean[][] marked) {
        marked[current[0]][current[1]] = true;
        if (next == word.length()) return true;
        if (current[0] - 1 >= 0 && !marked[current[0] - 1][current[1]] && board[current[0] - 1][current[1]] == word.charAt(next))
            if (dfs(board, word, new int[]{current[0] - 1, current[1]}, next + 1, marked)) return true;
        if (current[1] - 1 >= 0 && !marked[current[0]][current[1] - 1] && board[current[0]][current[1] - 1] == word.charAt(next))
            if (dfs(board, word, new int[]{current[0], current[1] - 1}, next + 1, marked)) return true;
        if (current[0] < board.length - 1 && !marked[current[0] + 1][current[1]] && board[current[0] + 1][current[1]] == word.charAt(next))
            if (dfs(board, word, new int[]{current[0] + 1, current[1]}, next + 1, marked)) return true;
        if (current[1] < board[0].length - 1 && !marked[current[0]][current[1] + 1] && board[current[0]][current[1] + 1] == word.charAt(next))
            if (dfs(board, word, new int[]{current[0], current[1] + 1}, next + 1, marked)) return true;
        marked[current[0]][current[1]] = false;
        return false;
    }


    //costant space solution
    public boolean existsWord(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (findPath(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findPath(char[][] board, int i, int j, String word, int index) {
        // word is completely checked.
        if (index == word.length()) return true;

        // check the boundaries.
        if (i<0 || i>=board.length || j<0 || j>=board[0].length) return false;

        // check the current cell.
        if (board[i][j] != word.charAt(index)) return false;

        // current cell has correct letter, mark the cell as visited
        char temp = board[i][j];
        board[i][j] = '$';

        // if current cell is ok, try to find path for the next char.
        boolean top = findPath(board, i-1, j, word, index+1);
        boolean bottom = findPath(board, i+1, j, word, index+1);
        boolean left = findPath(board, i, j-1, word, index+1);
        boolean right = findPath(board, i, j+1, word, index+1);
        if (top || bottom || left || right) return true;

        // restore visited cell
        board[i][j] = temp;
        return false;
    }
}

