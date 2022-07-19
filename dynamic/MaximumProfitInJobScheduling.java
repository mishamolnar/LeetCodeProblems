package LeetCode.dynamic;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/maximum-profit-in-job-scheduling/
public class MaximumProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] arr = new Job[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            arr[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(arr, (a, b) -> a.startTime - b.startTime);
        int currentMax = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); //0 - endTime, 1 - profit before that time
        for (int i = 0; i < startTime.length; i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= arr[i].startTime) {
                currentMax = Math.max(currentMax, pq.poll()[1]);
            }
            pq.add(new int[]{arr[i].endTime, currentMax + arr[i].profit});
        }
        while (!pq.isEmpty()) currentMax = Math.max(currentMax, pq.poll()[1]);
        return currentMax;
    }

    private static class Job {
        private int startTime;
        private int endTime;
        private int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        MaximumProfitInJobScheduling maxProf = new MaximumProfitInJobScheduling();
        System.out.println(maxProf.jobScheduling(new int[]{4,2,4,8,2},
        new int[]{5,5,5,10,8},
        new int[]{1,2,8,10,4}));
    }
}
