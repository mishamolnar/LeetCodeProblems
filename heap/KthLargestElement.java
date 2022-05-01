package LeetCode.heap;

import java.util.*;

public class KthLargestElement {

    // construct pq = O(n), but retrieve - O(logn) total complexity - O(n) + k*log(n)
    public int findKthLargest(int[] nums, int k) {
        List<Integer> input = new ArrayList<>(nums.length);
        for (int num : nums) {
            input.add(num);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(input);
        int result = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            result = priorityQueue.poll();
        }
        return result;
    }

    // average time complexity - O(n) memory constant
    public int findKthLargestQuickSelect(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        k = nums.length - k;
        while (hi > lo) {
            int j = partition(nums, lo, hi);
            if (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;
            else return nums[k];
        }
        return nums[k];
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi  + 1;
        while (true) {
            while (a[++i] < a[lo]) {
                if (i == hi) break; // found item on left to swap
            }

            while (a[lo] < a[--j]) {
                if (j == lo) break; // found item on right to swap
            }

            if (i >= j) break; //check if pointer cross
            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;
    }

    private static void exch(int[] a, int i, int j) {
        int buff = a[i];
        a[i] = a[j];
        a[j] = buff;
    }


    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        System.out.println(kthLargestElement.findKthLargestQuickSelect(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
