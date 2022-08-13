package LeetCode.math;

import java.util.HashMap;
import java.util.Map;

//
public class MaxPointsOnLine {
    public int maxPoints(int[][] points) {
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                if (j == i) continue;
                double angle = (points[i][1] - points[j][1]) / (double) (points[i][0] - points[j][0]);
                if (angle == -0) angle = 0;
                if (angle == Double.NEGATIVE_INFINITY) angle = Double.POSITIVE_INFINITY;
                int count = map.getOrDefault(angle, 0) + 1;
                map.put(angle, count);
                max = Math.max(count, max);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(0.0 / -10);
    }
}
