package LeetCode.design;

import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        if (pq.size() < k || pq.peek() < val) {
            pq.add(val);
        }
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}