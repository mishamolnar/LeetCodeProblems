package LeetCode.math;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

//https://leetcode.com/problems/moving-average-from-data-stream/solution/
public class MovingAverage {
    private int size;
    private Queue<Integer> queue;
    private long sum;

    public MovingAverage(int size) {
        this.size = size;
        this.queue = new ArrayDeque<>();
        this.sum = 0;
    }

    public double next(int val) {
        if (!queue.isEmpty() && queue.size() == size) sum -= queue.poll();
        queue.add(val);
        sum += val;
        return (double) sum / queue.size();
    }
}
