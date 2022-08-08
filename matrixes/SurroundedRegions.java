package LeetCode.matrixes;

    //https://leetcode.com/problems/surrounded-regions/
public class SurroundedRegions {
    private final static int[][] DIRECTIONS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || j == 0 || i == board.length - 1
                        || j == board[0].length - 1) allToZ(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Z') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    private void allToZ(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length
                || y >= board[0].length || board[x][y] != 'O') return;

        board[x][y] = 'Z';
        for (int[] dir : DIRECTIONS) {
            allToZ(board, x + dir[0], y + dir[1]);
        }
    }

    public static void main(String[] args) {
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(new char[][]{{'X', 'O', 'X'}, {'X', 'O', 'X'}, {'X', 'O', 'X'}});
    }


    //[["O","O","O","O","X","X"],
    // ["O","O","O","O","O","O"],
    // ["O","X","O","X","O","O"],
    // ["O","X","O","X","X","O"],
    // ["O","X","O","X","O","O"],
    // ["O","X","O","O","O","O"]]
}
