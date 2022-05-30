package LeetCode.matrixes;

import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/design-tic-tac-toe/solution/
public class TicTacToe {
    int winner = 0;
    Side[] horizontal;
    Side[] vertical;
    Side diagonal1;
    Side diagonal2;

    //O(n) space and O(1) time
    public TicTacToe(int n) {
        vertical = new Side[n];
        horizontal = new Side[n];
        for (int i = 0; i < n; i++) {
            vertical[i] = new Side(n);
            horizontal[i] = new Side(n);
        }
        diagonal1 = new Side(n);
        diagonal2 = new Side(n);
    }

    public int move(int row, int col, int player) {
        if (winner != 0) return winner;
        if (!horizontal[row].blocked && (horizontal[row].user == 0 || horizontal[row].user == player)) {
            horizontal[row].remains--;
            horizontal[row].user = player;
            if (horizontal[row].remains == 0) return winner = player;
        } else horizontal[row].blocked = true;
        if (!vertical[col].blocked && (vertical[col].user == 0 || vertical[col].user == player)) {
            vertical[col].remains--;
            vertical[col].user = player;
            if (vertical[col].remains == 0) return winner = player;
        } else vertical[col].blocked = true;
        if (!diagonal1.blocked && row == col && (diagonal1.user == 0 || diagonal1.user == player)) {
            diagonal1.remains--;
            diagonal1.user = player;
            if (diagonal1.remains == 0) return winner = player;
        } else if (row == col) diagonal1.blocked = true;
        if (!diagonal2.blocked && row == (horizontal.length - col - 1) && (diagonal2.user == 0 || diagonal2.user == player)) {
            diagonal2.remains--;
            diagonal2.user = player;
            if (diagonal2.remains == 0) return winner = player;
        }
        return 0;
    }

    private class Side{
        private int user;
        private int remains;
        boolean blocked;

        public Side(int remains) {
            this.user = 0;
            blocked = false;
            this.remains = remains;
        }
    }

    public static void main(String[] args) {
//        TicTacToe ticTacToe = new TicTacToe(3);
//        ticTacToe.move(0, 0, 1); // return 0 (no one wins)
//        ticTacToe.move(0, 2, 2); // return 0 (no one wins)
//        ticTacToe.move(2, 2, 1); // return 0 (no one wins)
//        ticTacToe.move(1, 1, 2); // return 0 (no one wins)
//        ticTacToe.move(2, 0, 1); // return 0 (no one wins)
//        ticTacToe.move(1, 0, 2); // return 0 (no one wins)
//        ticTacToe.move(2, 1, 1); // return 1 (player 1 wins)
        TicTacToe ticTacToe = new TicTacToe(2);
        ticTacToe.move(0,0,2);
        System.out.println(ticTacToe.move(0,1,1));
        System.out.println(ticTacToe.move(1,1,2));
    }


    /*
    * LeetCode implementation
    *
    *
    * int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int currentPlayer = (player == 1) ? 1 : -1;
        // update currentPlayer in rows and cols arrays
        rows[row] += currentPlayer;
        cols[col] += currentPlayer;
        // update diagonal
        if (row == col) {
            diagonal += currentPlayer;
        }
        //update anti diagonal
        if (col == (cols.length - row - 1)) {
            antiDiagonal += currentPlayer;
        }
        int n = rows.length;
        // check if the current player wins
        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n ||
                Math.abs(antiDiagonal) == n) {
            return player;
        }
        // No one wins
        return 0;
    }
    * */
}
