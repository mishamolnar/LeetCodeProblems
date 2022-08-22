package LeetCode.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


//https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<int[]> deque = new ArrayDeque<>(); // 0 index, 1 value;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst()[1] < nums[i]) //поки останній елемент менший за теперішній
                deque.pollFirst();
            if (!deque.isEmpty() && deque.peekLast()[0] == i - k) //якщо останній елемент вже поза межами вікна
                deque.pollLast();
            deque.addFirst(new int[]{i, nums[i]});
            res[Math.max(0, i - k + 1)] = deque.peekLast()[1];
        }
        return res;
    }

    public int[] maxSlidingWindowII(int[] nums, int k) {
        Deque<int[]> dq = new ArrayDeque<>(); //0 index, 1 value
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst()[1] <= nums[i])
                dq.pollFirst();
            if (!dq.isEmpty() && dq.peekLast()[0] <= i - k)
                dq.pollLast();
            dq.addFirst(new int[]{i, nums[i]});
            res[Math.max(0, i - k + 1)] = dq.getLast()[1];
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    
}
