package LeetCode.Intervals;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/solution/
//O(n * log(m)) n - total number of elements, m - number of lists 
public class SmallestRangeCoveringElementsFromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);//number, list index, index in a list
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            pq.add(new int[]{nums.get(i).get(0), i, 0});
            min = Math.min(nums.get(i).get(0), min);
            max = Math.max(nums.get(i).get(0), max);
        }

        int[] interval = new int[]{min, max};
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[2] + 1 == nums.get(curr[1]).size()) {
                return interval;
            }
            int[] next = new int[]{nums.get(curr[1]).get(curr[2] + 1), curr[1], curr[2] + 1};
            pq.add(next);
            max = Math.max(next[0], max);
            min = pq.peek()[0];
            if (max - min < interval[1] - interval[0]) {
                interval[0] = min;
                interval[1] = max;
            }
        }
        return interval;
    }

    public static void main(String[] args) {
        SmallestRangeCoveringElementsFromKLists small = new SmallestRangeCoveringElementsFromKLists();
        System.out.println(Arrays.toString(small.smallestRange(List.of(
                List.of(4,10,15,24,26),
                List.of(0,9,12,20),
                List.of(5,18,22,30)
        ))));
    }
}
