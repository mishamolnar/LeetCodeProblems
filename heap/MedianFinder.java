package LeetCode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//
class MedianFinder {
    private Queue<Integer> small = new PriorityQueue(Comparator.reverseOrder());
    private Queue<Integer> large = new PriorityQueue();

    // Adds a number into the data structure.
    public void addNum(int num) {
        large.add(num);
        small.add(large.poll());
        if (large.size() < small.size())
            large.add(small.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        return large.size() > small.size()
                ? large.peek()
                : (large.peek() + small.peek()) / 2.0;
    }
}