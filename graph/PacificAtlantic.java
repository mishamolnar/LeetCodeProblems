package LeetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// link
// time and space complexity - O(n*m) and O(n*m) for both
public class PacificAtlantic {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlanticTwo(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (i == 0 || j == 0) dfs(heights, res, pacific, atlantic, i, j);
            }
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (i == heights.length - 1 || j == heights[0].length - 1) dfs(heights, res, atlantic, pacific, i, j);
            }
        }
        return res;
    }

    private void dfs(int[][] heights, List<List<Integer>> result, boolean[][] current, boolean[][] oposite,  int x, int y) {
        if (x < 0 || y < 0 || x >= heights.length || y >= heights[0].length || current[x][y]) return;
        current[x][y] = true;
        if (oposite[x][y]) result.add(List.of(x, y));
        for (int[] dir : DIRECTIONS) {
            int x1 = x + dir[0];
            int y1 = y + dir[1];
            if (x1 < 0 || y1 < 0 || x1 >= heights.length || y1 >= heights[0].length) continue;
            if (heights[x1][y1] < heights[x][y]) continue;
            dfs(heights, result, current, oposite, x1, y1);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length]; //isMarked analog for pacific coast
        boolean[][] atlantic = new boolean[heights.length][heights[0].length]; // isMarked analog for atlantic coast
        List<List<Integer>> result = new ArrayList<>(); // result to return
        for (int i = 0; i < heights[0].length; i++) { //running dfs for top and bottom, top for pacific, bottom for atlantic
            dfs(0, i, Integer.MIN_VALUE, pacific, atlantic, result, heights);
            dfs(heights.length - 1,  i, Integer.MIN_VALUE, atlantic, pacific, result, heights);
        }
        for (int i = 0; i < heights.length; i++) {
            dfs(i, 0, Integer.MIN_VALUE, pacific, atlantic, result, heights); //running dfs for right and left, left for pacific and right for atlantic
            dfs(i, heights[0].length - 1, Integer.MIN_VALUE, atlantic, pacific, result, heights);
        }
        return result;
    }

    private void dfs (int i, int j, int prevHeights, boolean[][] current, boolean[][] oposite, List<List<Integer>> result, int[][] heights) {
        if (i < 0 || j < 0 || i >= current.length || j >= current[0].length) return; // if we out of bounds - return
        if (current[i][j] || heights[i][j] < prevHeights) return; // if already marked or can't flow - return
        current[i][j] = true;
        if (oposite[i][j]) {
            result.add(Arrays.asList(i, j)); //if marked in both oceans - add to solution
        }
        for (int[] w : DIRECTIONS) {
            dfs(i + w[0], j + w[1], heights[i][j], current, oposite, result, heights); // run dfs for 4 directions (checking for out of bounds in the start of next recursion
        }
    }

    public static void main(String[] args) {
        PacificAtlantic pacificAtlantic = new PacificAtlantic();
        List<List<Integer>> result = pacificAtlantic.pacificAtlanticTwo(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
        System.out.println(result.toString());
    }
}
