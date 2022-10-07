package LeetCode.heap;

import java.util.PriorityQueue;

public class MaximumNumberOfEatenApples {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int res = 0;
        for (int i = 0; i < apples.length; i++) {
            if (apples[i] != 0 || days[i] != 0)
                pq.add(new int[]{apples[i], i + days[i]});
            while (!pq.isEmpty() && (pq.peek()[1] <= i || pq.peek()[0] == 0))
                pq.poll();
            if (!pq.isEmpty()) {
                res++;
                pq.add(new int[]{pq.peek()[0] - 1, pq.poll()[1]});
            }
        }
        int day = days.length;
        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && (pq.peek()[1] <= day || pq.peek()[0] == 0))
                pq.poll();
            day++;
            if (!pq.isEmpty()) {
                res++;
                pq.add(new int[]{pq.peek()[0] - 1, pq.poll()[1]});
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumNumberOfEatenApples maximumNumberOfEatenApples = new MaximumNumberOfEatenApples();
        System.out.println(maximumNumberOfEatenApples.eatenApples(new int[]{3,0,0,0,0,2}, new int[]{3,0,0,0,0,2}));
        System.out.println(maximumNumberOfEatenApples.eatenApples(new int[]{1}, new int[]{2}));
    }
}
