package LeetCode.matrixes;

public class GameOfLife {
    private int[][] DIRECTIONS = new int[][] {{-1, -1}, {0, -1}, {-1, 0}, {-1, 1}, {1, 0}, {1, -1}, {0, 1}, {1, 1}};
    
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] % 100 == 0) continue;
                for (int[] dir : DIRECTIONS) {
                    if (i + dir[0] >= 0 && i + dir[0] < board.length 
                            && j + dir[1] >= 0 && j + dir[1] < board[0].length) {
                        board[i + dir[0]][j + dir[1]] += 100;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] % 100 == 0) {
                    if (board[i][j] / 100 == 3)
                        board[i][j]++;
                } else {
                    if (board[i][j] / 100 > 3 || board[i][j] / 100 < 2)
                        board[i][j]--;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] %= 100;
            }
        }
    }

    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.gameOfLife(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}});
    }
}
