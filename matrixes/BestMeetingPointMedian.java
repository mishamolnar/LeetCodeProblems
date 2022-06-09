package LeetCode.matrixes;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/best-meeting-point/submissions/
public class BestMeetingPointMedian {

    //O(mn) time and space
    public int minTotalDistance(int[][] grid) {
        List<Integer> columns = collectHousesByColumns(grid);
        List<Integer> rows = collectHousesByRows(grid);
        int bestRow = rows.get(rows.size() / 2);
        int bestCol = columns.get(columns.size() / 2);
        return minDistance(rows, bestRow) + minDistance(columns, bestCol);
    }

    private int minDistance(List<Integer> list, int origin) {
        int res = 0;
        for (Integer integer : list) {
            res += Math.abs(origin - integer);
        }
        return res;
    }

    private List<Integer> collectHousesByRows(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) result.add(i);
            }
        }
        return result;
    }

    private List<Integer> collectHousesByColumns(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) result.add(i);
            }
        }
        return result;
    }
}
