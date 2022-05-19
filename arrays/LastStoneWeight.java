package LeetCode.arrays;

import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.com/problems/last-stone-weight/
public class LastStoneWeight {

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        lastStoneWeight.lastStoneWeight(new int[]{31,26,33,21,40});
    }

    public int lastStoneWeight(int[] stones) {
        List<Integer> list = Arrays.stream(stones).boxed().collect(Collectors.toList());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(list);
        while (pq.size() > 1) {
            pq.add(Math.abs(pq.poll() - pq.poll()));
        }
        return pq.poll();
    }
}
