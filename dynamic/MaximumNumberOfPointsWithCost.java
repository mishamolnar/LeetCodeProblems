package LeetCode.dynamic;

import java.util.Arrays;

//https://leetcode.com/mishamolnar/
public class MaximumNumberOfPointsWithCost {
    public long maxPoints(int[][] points) {
        long[] curr = new long[points[0].length];

        for (int i = 0; i < points.length; i++) {
            normalize(curr);
            for (int j = 0; j < points[i].length; j++) {
                curr[j] += points[i][j];
            }
        }

        return Arrays.stream(curr).max().orElse(-1);
    }

    private void normalize(long[] points) {
        long max = points[0];
        for (int i = 1; i < points.length; i++) {
            max = Math.max(--max, points[i]);
            points[i] = max;
        }

        max = points[points.length - 1];
        for (int i = points.length - 2; i >= 0; i--) {
            max = Math.max(points[i], --max);
            points[i] = max;
        }
    }
}
