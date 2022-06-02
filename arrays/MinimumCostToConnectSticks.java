package LeetCode.arrays;

import java.util.PriorityQueue;

//https://leetcode.com/problems/minimum-cost-to-connect-sticks/
public class MinimumCostToConnectSticks {
    //space - O(n) time n log n
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks) {
            pq.add(stick);
        }
        int sum = 0;
        while (pq.size() > 1) {
            int buff = pq.poll() + pq.poll();
            sum += buff;
            pq.add(buff);
        }
        return sum;
    }

    public static void main(String[] args) {
        MinimumCostToConnectSticks minimum = new MinimumCostToConnectSticks();
        System.out.println(minimum.connectSticks(new int[]{1,8,3,5}));
    }
}
