package LeetCode.myImpls;

import java.util.PriorityQueue;

public class BinaryHeapPQ {
    private final int[] pq;
    private int currentCapacity;

    public BinaryHeapPQ(int capacity) {
        pq = new int[capacity + 1];
    }

    public void insert(int key) {
        pq[++currentCapacity] = key;
        swim(currentCapacity);
    }

    public int deleteMax() {
        int max = pq[1];
        exch(1, currentCapacity--);
        sink(1);
        pq[currentCapacity + 1] = 0;
        return max;
    }

    private void sink(int k) {
        while (2 * k <= currentCapacity) {
            int j = 2 * k;
            if (j < currentCapacity && pq[j] < pq[j + 1]) j++;
            if (!(pq[k] < pq[j])) break;
            exch(k, j);
            k = j;
        }
    }


    private void swim(int k) {
        while (k > 1 && pq[k / 2] < pq[k]) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void exch(int i, int j) {
        int t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

}
