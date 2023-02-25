package LeetCode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimizeDeviationArray {
    public int minimumDeviation(int[] nums) {
        Arrays.stream(nums).max();
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            max.add(num);
            min.add(num);
        }
        int res = max.peek() - min.peek();
        while (min.peek() % 2 == 1) {
            int curr = min.poll();
            min.add(curr * 2);
            max.add(curr * 2);
            res = Math.min(res, max.peek() - min.peek());
        }
        while (max.peek() % 2 == 0) {
            int curr = max.poll();
            min.add(curr / 2);
            max.add(curr / 2);
            res = Math.min(res, max.peek() - min.peek());
        }
        return res;
    }
}
