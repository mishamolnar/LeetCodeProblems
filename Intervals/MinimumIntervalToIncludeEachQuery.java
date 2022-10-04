package LeetCode.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumIntervalToIncludeEachQuery {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Map<Integer, List<Integer>> q = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            q.putIfAbsent(queries[i], new ArrayList<>());
            q.get(queries[i]).add(i);
        }
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        Arrays.sort(queries);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1] - a[0], b[1] - b[0]));
        int intervalsPointer = 0;
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            while (intervalsPointer < intervals.length && intervals[intervalsPointer][0] <= queries[i])
                pq.add(intervals[intervalsPointer++]);
            while (!pq.isEmpty() && (pq.peek()[1] < queries[i] || pq.peek()[0] > queries[i]))
                pq.poll();
            for (Integer index : q.get(queries[i])) {
                res[index] = pq.isEmpty() ? -1 : (pq.peek()[1] - pq.peek()[0] + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumIntervalToIncludeEachQuery minim = new MinimumIntervalToIncludeEachQuery();
        System.out.println(minim.minInterval(new int[][]{{1, 4}, {2, 4}, {3, 6}, {4, 4}}, new int[]{2, 3, 4, 5}));
    }
}
