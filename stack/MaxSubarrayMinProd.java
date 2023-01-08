package LeetCode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MaxSubarrayMinProd {
    public int maxSumMinProduct(int[] nums) {
        Deque<Integer> st = new LinkedList<>();
        int[] right = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peekFirst()] > nums[i]) {
                right[st.pollFirst()] = i;
            }
            st.addFirst(i);
        }
        while (!st.isEmpty()) right[st.pollFirst()] = nums.length;

        int[] left = new int[nums.length + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peekFirst()] > nums[i]) {
                left[st.pollFirst()] = i;
            }
            st.addFirst(i);
        }
        while (!st.isEmpty()) left[st.poll()] = -1;

        long[] sums = new long[nums.length];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }

        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            long le = left[i] == -1 ? 0 : sums[left[i]];
            res = Math.max(res, nums[i] * (sums[right[i] - 1] - le));
        }
        return (int) (res % 1_000_000_007);
    }

    public static void main(String[] args) {
        MaxSubarrayMinProd max = new MaxSubarrayMinProd();
        System.out.println(max.maxSumMinProduct(new int[]{2,3,2,1}));
    }
}
