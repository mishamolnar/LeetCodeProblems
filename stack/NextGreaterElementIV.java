package LeetCode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Stack;

public class NextGreaterElementIV {

    //PQ solution
    public int[] secondGreaterElement(int[] nums) {
        Deque<Integer> first = new ArrayDeque<>();
        PriorityQueue<Integer> second = new PriorityQueue<>((a, b) -> Integer.compare(nums[a], nums[b]));
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length; i++) {
            while (!second.isEmpty() && nums[i] > nums[second.peek()]) {
                res[second.poll()] = nums[i];
            }
            while (!first.isEmpty() && nums[i] > nums[first.peekLast()]) {
                second.add(first.pollLast());
            }
            first.addLast(i);
        }
        return res;
    }

    public int[] secondGreaterElements(int[] nums) {
        Deque<Integer> first = new ArrayDeque<>();
        Deque<Integer> second = new ArrayDeque<>();
        Deque<Integer> temp = new ArrayDeque<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length; i++) {
            while (!second.isEmpty() && nums[i] > nums[second.peekLast()]) {
                res[second.pollLast()] = nums[i];
            }
            while (!first.isEmpty() && nums[i] > nums[first.peekLast()]) {
                temp.addLast(first.pollLast());
            }
            while (!temp.isEmpty()) {
                second.addLast(temp.pollLast());
            }
            first.addLast(i);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterElementIV().secondGreaterElements(new int[]{12, 4, 2, 4, 5, 3, 5, 4, 31, 2, 4, 1, 9, 5, 8, 7, 5, 3})));
    }
}
