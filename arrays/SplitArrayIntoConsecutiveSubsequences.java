package LeetCode.arrays;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> pq = new HashMap<>();
        for (int num : nums) {
            if (pq.containsKey(num - 1)) {
                int len = pq.get(num - 1).poll();
                if (pq.get(num - 1).size() == 0)
                    pq.remove(num - 1);
                pq.putIfAbsent(num, new PriorityQueue<>());
                pq.get(num).add(len + 1);
            } else {
                pq.putIfAbsent(num, new PriorityQueue<>());
                pq.get(num).add(1);
            }
        }
        return pq.values()
                .stream()
                .flatMap(pqnum -> pqnum.stream())
                .noneMatch(a -> a < 3);
    }

    public static void main(String[] args) {
        SplitArrayIntoConsecutiveSubsequences split = new SplitArrayIntoConsecutiveSubsequences();
        System.out.println(split.isPossible(new int[]{1,2,3,3,4,5}));
    }
}
