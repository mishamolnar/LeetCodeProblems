package LeetCode.arrays;

import java.util.List;

//https://leetcode.com/problems/minimum-time-difference/submissions/
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        boolean[] times = new boolean[1880];
        for (String timePoint : timePoints) {
            int min = toMinutes(timePoint);
            if (times[min]) return 0;
            times[min] = true;
            times[min + 1440] = true;
        }
        int last = -1, diff = Integer.MAX_VALUE;
        for (int i = 0; i < times.length; i++) {
            if (times[i]) {
                if (last != -1) {
                    diff = Math.min(i - last, diff);
                }
                last = i;
            }
        }
        return diff;
    }

    private int toMinutes(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}
