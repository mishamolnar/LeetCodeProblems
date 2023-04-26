package LeetCode.heap;

import java.util.HashSet;
import java.util.PriorityQueue;

class SmallestInfiniteSet {
    private int smallest;
    private PriorityQueue<Integer> pq;
    private HashSet<Integer> set;

    public SmallestInfiniteSet() {
        smallest = 1;
        pq = new PriorityQueue<>();
        set = new HashSet<>();
    }
    
    public int popSmallest() {
        if (pq.isEmpty()) {
            return smallest++;
        }
        int res = pq.poll();
        set.remove(res);
        return res;
    }
    
    public void addBack(int num) {
        if (num < smallest && !set.contains(num)) {
            set.add(num);
            pq.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */