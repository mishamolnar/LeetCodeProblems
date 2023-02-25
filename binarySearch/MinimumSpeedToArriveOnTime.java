package LeetCode.binarySearch;

import java.util.Arrays;

public class MinimumSpeedToArriveOnTime {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (Math.ceil(hour) < dist.length) return  -1;
        int left = 1, right = Arrays.stream(dist).max().getAsInt() + 1;
        while (right - left > 1) {
            int middle = left + (right - left) / 2;
            if (test(dist, hour, middle)) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return left;
    }

    private boolean test(int[] dist, double hour, double speed) {
        double time = 0;
        for (int di : dist) {
            time = Math.ceil(time);
            time += (double) di / speed;
        }
        return time <= hour;
    }

    public static void main(String[] args) {
        System.out.println(Math.ceil(0.0));
    }
}
