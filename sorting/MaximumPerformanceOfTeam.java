package LeetCode.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/maximum-performance-of-a-team/
public class MaximumPerformanceOfTeam {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] merged = new int[n][2]; //0 - eff, 1 - speed
        for (int i = 0; i < speed.length; i++) {
            merged[i][0] = efficiency[i];
            merged[i][1] = speed[i];
        }
        Arrays.sort(merged, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> speeds = new PriorityQueue<>(k);
        long res = 0, speedSum = 0;
        for (int[] ints : merged) {
            speedSum += ints[1];
            speeds.add(ints[1]);
            if (speeds.size() > k)
                speedSum -= speeds.poll();
            res = Math.max(res, speedSum * ints[0]);
        }
        return (int) (res % (long)(1e9 + 7));
    }
}
