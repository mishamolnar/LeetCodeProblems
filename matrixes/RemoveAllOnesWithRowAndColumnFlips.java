package LeetCode.matrixes;

//https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips/submissions/
public class RemoveAllOnesWithRowAndColumnFlips {

    //O(mn) time
    //constant space
    public boolean removeOnes(int[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) flipColum(grid, i); //так як нам треба шо б все було нулями
            // ми перевертаємо значення ~1~ в першому рядку і всі значення в цих колонках відповідно теж
        }
        for (int i = 1; i < grid.length; i++) {
            int count = countInRow(grid[i]); //разом з цим ми мали перевернути інші значення на 0, якщо ні - то неможливо прибрати всі одинички,
            //так як для цього потрібно буде знову перевертати колонки і зафакапиться вже виправлений рядок
            if (count > 0 && count < grid[0].length) return false;
        }
        return true;
    }

    private int countInRow(int[] row) {
        int sum = 0;
        for (int i : row) {
            sum += i;
        }
        return sum;
    }

    private void flipColum(int[][] grid, int column) {
        for (int i = 1; i < grid.length; i++) {
            if (grid[i][column] == 0) grid[i][column] = 1;
            else grid[i][column] = 0;
        }
    }
}
