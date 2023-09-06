package LeetCode.greedy;

import java.util.PriorityQueue;

public class MinimumNumberOfTaps {

    public int minTaps(int n, int[] ranges) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] > 0)
                pq.add(new int[]{i - ranges[i], i + ranges[i]});
        }
        int end = -1, res = 0;
        for (int i = 0; i <= n; i++) {
            if (i <= end)
                continue;
            while (!pq.isEmpty() && pq.peek()[0] <= i) {
                end = Math.max(pq.poll()[1], end);
            }
            if (end < i)
                return -1;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfTaps().minTaps(35, new int[]{1,0,4,0,4,1,4,3,1,1,1,2,1,4,0,3,0,3,0,3,0,5,3,0,0,1,2,1,2,4,3,0,1,0,5,2}));
    }

    //        |                 |               |                 |       |
    //1,0,4,0,4,1,4,3,1,1,1,2,1,4,0,3,0,3,0,3,0,5,3,0,0,1,2,1,2,4,3,0,1,0,5,2
    //0,1,2,3,4,5,6,7,8,9|0,1,2,3,4,5,6,7,8,9|0,1,2,3,4,5,6,7,8,9|0,1,2,3,4,5
}
