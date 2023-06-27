package LeetCode.heap;

import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        int leftPointer = candidates - 1, rightPointer = Math.max(leftPointer + 1, costs.length - candidates);
        for (int i = 0; i <= leftPointer; i++)
            pq.add(new int[]{costs[i], i, 0});
        for (int i = rightPointer; i < costs.length; i++)
            pq.add(new int[]{costs[i], i, 1});
        long res = 0;
        for (int i = 0; i < k; i++) {
            int[] candidate = pq.poll();
            res += candidate[0];
            if (rightPointer - leftPointer > 1) {
                pq.add(candidate[2] == 0 ? new int[]{costs[++leftPointer], leftPointer, 0} : new int[]{costs[--rightPointer], rightPointer, 1});
            }
        }
        return res;
    }
}
