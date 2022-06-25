package LeetCode.matrixes;

import java.util.HashMap;

//https://leetcode.com/problems/number-of-corner-rectangles/
public class NumberOfCornerRectangles {
    public int countCornerRectangles(int[][] grid) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int[] row : grid) {
            for (int left = 0; left < row.length; left++) {
                for (int right = left + 1; right < row.length; right++) {
                    if (row[left] == 0 || row[right] == 0) continue;
                    int hash = left * 200 + right;
                    int occur = map.getOrDefault(hash, 0);
                    ans += occur;
                    map.put(hash, occur + 1);
                }
            }
        }
        return ans;
    }
}
