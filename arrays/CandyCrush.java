package LeetCode.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/candy-crush/solution/
public class CandyCrush {
    private int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

/*
Time Complexity: O((R*C)^2), where R, CR,C is the number of rows and columns in board.
We need O(R*C) to scan the board, and we might crush only 3 candies repeatedly.
Space Complexity: O(1) additional complexity, as we edit the board in place.
*/
    public int[][] candyCrush(int[][] board) {
        boolean found = false;
        while (true) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    int prev = board[i][j];
                    int f = dfs(board, i, j, 2001);
                    if (f > 2) {
                        dfs(board, i, j, 0);
                        found = true;
                    }
                    else dfs(board, i, j, prev);
                }
            }
            if (found) {
                drop(board);
                found = false;
            } else break;
        }
        return board;
    }

    private int dfs(int[][] board, int x, int y, int setTo) {
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{x, y});
        int candy = board[x][y];
        int size = 0;
        while (!stack.empty()) {
            int[] curr = stack.pop();
            board[curr[0]][curr[1]] = setTo;
            size++;
            for (int[] dir : DIRECTIONS) {
                int currX = curr[0] + dir[0];
                int currY = curr[1] + dir[1];
                if (currX < 0 || currY < 0 || currX >= board.length
                        || currY >= board[0].length || board[currX][currY] == 0
                        || board[currX][currY] != candy) continue;
                stack.add(new int[]{currX, currY});
            }
        }
        return size;
    }

    private void drop(int[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            int left = board.length - 1;
            for (int j = board.length - 1; j >= 0; j--) {
                if (board[j][i] != 0) {
                    board[left][i] = board[j][i];
                    left--;
                }
            }
            while (left >= 0) board[left--][i] = 0;
        }
    }

    public static void main(String[] args) {
        CandyCrush candyCrush = new CandyCrush();
        System.out.println(candyCrush.candyCrush(new int[][]{{110,5,112,113,114},{210,211,5,213,214},{310,311,3,313,314},{410,411,412,5,414},{5,1,512,3,3},{610,4,1,613,614},{710,1,2,713,714},{810,1,2,1,1},{1,1,2,2,2},{4,1,4,4,1014}}));
    }
}
