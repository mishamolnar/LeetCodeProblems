package LeetCode.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MaximumNumberOfVisiblePoints {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int count = 0;
        for (List<Integer> p : points) {
            int dx = p.get(0) - location.get(0);
            int dy = p.get(1) - location.get(1);
            if (dx == 0 && dy == 0) { // edge case of same point
                count++;
                continue;
            }
            angles.add(Math.atan2(dy, dx) * (180 / Math.PI));
        }
        Collections.sort(angles);
        List<Double> tmp = new ArrayList<>(angles);
        for (double d : angles) tmp.add(d + 360); // concatenate to handle edge case
        int res = count;
        for (int i = 0, j = 0; i < tmp.size(); i++) {
            while (tmp.get(i) - tmp.get(j) > angle) {
                j++;
            }
            res = Math.max(res, count + i - j + 1);
        }
        return res;
    }


    public static void main(String[] args) {
        MaximumNumberOfVisiblePoints maximumNumberOfVisiblePoints = new MaximumNumberOfVisiblePoints();
        System.out.println(maximumNumberOfVisiblePoints.visiblePoints(List.of(List.of(1,0), List.of(2,1)), 13, List.of(1, 1)));
    }

}
