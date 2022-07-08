package LeetCode.matrixes;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        for (int i = 0; i < 9; i++) rows[i] = new HashSet<>();
        Set<Character>[] columns = new HashSet[9];
        for (int i = 0; i < 9; i++) columns[i] = new HashSet<>();
        Set<Character>[] rec = new HashSet[9];
        for (int i = 0; i < 9; i++) rec[i] = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (!Character.isDigit(c)) continue;
                if (rows[i].contains(c)
                        || columns[j].contains(c)
                        || rec[getRec(i, j)].contains(c)) return false;
                rows[i].add(c);
                columns[j].add(c);
                rec[getRec(i, j)].add(c);
            }
        }
        return true;
    }

    private int getRec(int x, int y) {
        return (x / 3) * 3 + (y / 3);
    }


    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(new char[][]{{'1', '2', '3'}, {'.', '2', '3'}, {'1', '2', '3'}}));
    }
}
