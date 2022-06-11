package LeetCode.graph;

import LeetCode.unionFind.NumberOfIslandsII;

import java.util.*;

//https://leetcode.com/problems/number-of-distinct-islands-ii/
public class NumberOfDistinctIslandsII {
    private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int numDistinctIslands2(int[][] grid) {
        Set<Map<Integer, Integer>> distinctIslands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    List<int[]> island = new ArrayList<>();
                    getIsland(i, j, grid, island);
                    distinctIslands.add(computeDistances(island));
                }
            }
        }
        return distinctIslands.size();
    }

    private void getIsland(int x, int y, int[][] grid, List<int[]> result) {
        if (x < 0 || y < 0 || x >= grid.length
                || y >= grid[0].length || grid[x][y] == 0) return;
        result.add(new int[]{x, y});
        grid[x][y] = 0;
        for (int[] dir : DIRECTIONS) {
            getIsland(x + dir[0], y + dir[1], grid, result);
        }
    }

    private Map<Integer, Integer> computeDistances(List<int[]> island) {
        Map<Integer, Integer> result = new HashMap<>();
        if (island.size() == 1) return Map.of(0, 1);
        for (int i = 0; i < island.size(); i++) {
            for (int j = i + 1; j < island.size(); j++) {
                int dist = (int) (Math.pow(island.get(i)[0] - island.get(j)[0], 2)
                        + Math.pow(island.get(i)[1] - island.get(j)[1], 2)) * 100;
                result.put(dist, result.getOrDefault(dist, 0) + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfDistinctIslandsII number = new NumberOfDistinctIslandsII();
        System.out.println(number.numDistinctIslands2(new int[][]{{0, 1}}));
    }
}
