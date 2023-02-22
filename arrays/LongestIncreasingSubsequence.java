package LeetCode.arrays;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    private int longestIncreasing(int[] arr) { //no binary search
        int[] sequence = new int[arr.length];
        Arrays.fill(sequence, Integer.MAX_VALUE);
        int res = 0;
        for (int curr : arr) {
            int index = 0;
            while (sequence[index] < curr) index++;
            sequence[index] = curr;
            res = Math.max(res, index);
        }
        return res;
    }


    private int longestIncreasingWithBS(int[] arr) {
        int[] sequence = new int[arr.length];
        Arrays.fill(sequence, Integer.MAX_VALUE);
        int res = 0;
        for (int curr : arr) {
            int index = binarySearch(sequence, curr);
            sequence[index] = curr;
            res = Math.max(res, index);
        }
        return res;
    }


    private int binarySearch(int[] sequence, int target) { //index of bigger or same
        int left = 0, right = sequence.length;
        while (right - left > 1) {
            int middle = left + (right - left) / 2;
            if (sequence[middle] < target) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return right == sequence.length ? right - 1 : right;
    }
}
