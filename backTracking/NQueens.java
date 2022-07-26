package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/n-queens/submissions/
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }

    private void dfs(char[][] board, int column, List<List<String>> res) {//n!
        if (column == board.length) {
            res.add(Arrays
                    .stream(board)
                    .map(String::new)
                    .collect(Collectors.toList()));
        } else {
            for (int i = 0; i < board.length; i++) {
                if (validate(board, i, column)) {
                    board[i][column] = 'Q';
                    dfs(board, column + 1, res);
                    board[i][column] = '.';
                }
            }
        }
    }

    private boolean validate(char[][] board, int x, int y) { //n2
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if ((board[i][j] == 'Q')
                    && (x + j == y + i || x + y == i + j || i == x)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));
    }
}
