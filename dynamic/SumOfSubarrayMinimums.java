package LeetCode.dynamic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        int[] left = new int[arr.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] > arr[i]) {
                left[deque.pollLast()] = i - 1;
            }
            deque.addLast(i);
        }
        while (!deque.isEmpty())
            left[deque.pollLast()] = arr.length - 1;
        int[] right = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && arr[deque.peekLast()] > arr[i])
                right[deque.pollLast()] = i + 1;
            deque.addLast(i);
        }
        while (!deque.isEmpty())
            right[deque.pollLast()] = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (((arr[i] * (i - right[i] + 1) % 1_000_000_007) + (arr[i] * (left[i] - i + 1) % 1_000_000_007)));
            sum %= 1_000_000_007;
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfSubarrayMinimums sum = new SumOfSubarrayMinimums();
        System.out.println(sum.sumSubarrayMins(new int[]{11,81,94,43,3}));
    }
}
