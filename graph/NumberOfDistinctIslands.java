package LeetCode.graph;

import java.util.*;

//https://leetcode.com/problems/number-of-distinct-islands/submissions/
public class NumberOfDistinctIslands {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int[][] grid;
    private boolean[][] seen;
    private Set<Map.Entry<Integer, Integer>> currentIsland;
    private int currRowOrigin;
    private int currColOrigin;

    private void dfs(int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
        if (grid[row][col] == 0 || seen[row][col]) return;
        seen[row][col] = true;
        currentIsland.add(Map.entry(row - currRowOrigin, col - currColOrigin));
        for (int[] dir : DIRECTIONS) {
            dfs(row + dir[0], col + dir[1]);
        }
    }


    //hashing, technically O(mn) time and space
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        this.seen = new boolean[grid.length][grid[0].length];
        Set<Set<Map.Entry<Integer, Integer>>> islands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                this.currRowOrigin = i;
                this.currColOrigin = j;
                this.currentIsland = new HashSet<>();
                dfs(i, j);
                if (!currentIsland.isEmpty()) islands.add(currentIsland);
            }
        }
        return islands.size();
    }


    //brute force solution, O(m2n2) time and O(nm) memory
    public int numDistinctIslandsBruteForce(int[][] grid) {
        List<List<int[]>> unique = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    List<int[]> list = new ArrayList<>();
                    dfs(grid, list, i, j);
                    if (currentIslandUnique(transform(list), unique)) unique.add(transform(list));
                }
            }
        }
        return unique.size();
    }

    private void dfs(int[][] grid, List<int[]> list, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return;
        grid[i][j] = 0;
        list.add(new int[]{i, j});
        for (int[] dir : DIRECTIONS) {
            dfs(grid, list, i + dir[0], j + dir[1]);
        }
    }

    private List<int[]> transform(List<int[]> list) {
        int[] min = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int[] arr : list) {
            if (arr[0] < min[0] || (arr[0] == min[0] && arr[1] < min[1])) min = arr.clone();
        }
        for (int[] ints : list) {
            ints[0] -= min[0];
            ints[1] -= min[1];
        }
        return list;
    }

    private boolean currentIslandUnique(List<int[]> currentIsland, List<List<int[]>> uniqueIslands) {
        for (List<int[]> otherIsland : uniqueIslands) {
            if (currentIsland.size() != otherIsland.size()) continue;
            if (equalIslands(currentIsland, otherIsland)) {
                return false;
            }
        }
        return true;
    }

    private boolean equalIslands(List<int[]> island1, List<int[]> island2) {
        for (int i = 0; i < island1.size(); i++) {
            if (island1.get(i)[0] != island2.get(i)[0] || island1.get(i)[1] != island2.get(i)[1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NumberOfDistinctIslands number = new NumberOfDistinctIslands();
        System.out.println(number.numDistinctIslands(new int[][]{{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}}));
    }
}
