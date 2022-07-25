package LeetCode.matrixes;

import java.util.*;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }

    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell

                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }

    // not valid
    public void solveSudokuHashMap(char[][] board) {
        HashMap<Integer, HashSet<Character>> map = new HashMap<>();
        for (int i = 0; i < 81; i++) {
            map.put(i, new HashSet<>(List.of('1', '2', '3', '4', '5', '6', '7', '8', '9')));
        }

        int toSet = 81;
        Set<Integer> cells = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    toSet--;
                    int cell = i * 9 + j;
                    char c = board[i][j];
                    for (Integer neighbour : getAllNeighbours(cell)) {
                        map.get(neighbour).remove(c);
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int cell = i * 9 + j;
                if (map.get(cell).size() == 1 && board[i][j] == '.') {
                    cells.add(cell);
                }
            }
        }

        while (toSet > 0) {
            int cell = cells.iterator().next();
            cells.remove(cell);
            if (map.get(cell).size() < 1) continue;
            char removed = map.get(cell).iterator().next();
            board[cell / 9][cell % 9] = removed;
            toSet--;
            for (Integer neighbour : getAllNeighbours(cell)) {
                map.get(neighbour).remove(removed);
                if (board[neighbour / 9][neighbour % 9] == '.')
                    cells.add(neighbour);
            }
        }
    }


    private List<Integer> getAllNeighbours(int cell) {
        List<Integer> res = new ArrayList<>();

        for (int i = cell - (cell % 9); i < cell - (cell % 9) + 9; i++) {
            res.add(i);
        }

        for (int i = cell % 9; i < 81; i += 9) {
            res.add(i);
        }

        res.addAll(getSquareCoords(cell));
        return res;
    }

    private List<Integer> getSquareCoords(int i) {
        int height = i < 27 ? 0 : (i < 54) ? 3 : 6;
        int width = i % 9 < 3 ? 0 : (i % 9 < 6) ? 3 : 6;

        List<Integer> res = new ArrayList<>();
        for (int j = height; j < height + 3; j++) {
            for (int k = width; k < width + 3; k++) {
                int cell = j * 9 + k;
                if (cell != i)
                    res.add(cell);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        char[][] sudoku = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        char[][] sudoku2 = {
                {'.','.','.','2','.','.','.','6','3'},
                {'3','.','.','.','.','5','4','.','1'},
                {'.','.','1','.','.','3','9','8','.'},
                {'.','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','3','8','.','.','.'},
                {'.','3','.','.','.','.','.','.','.'},
                {'.','2','6','3','.','.','5','.','.'},
                {'5','.','3','7','.','.','.','.','8'},
                {'4','7','.','.','.','1','.','.','.'}};
        sudokuSolver.solveSudoku(sudoku2);
        System.out.println(Arrays.deepToString(sudoku2));
    }
}
