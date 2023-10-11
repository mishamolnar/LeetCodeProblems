package LeetCode.binarySearch;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinimumNumberOfOperationsToMakeArrayContinuous {
    public int minOperations(int[] nums) {
        int[] arr = IntStream.of(nums).distinct().toArray();

        int n = nums.length, ans = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int left = 0; left < arr.length; left++) {
            int max = arr[left] + n - 1;
            int right = binarySearch(arr, left, max);
            int count = right - left + 1;
            ans = Math.min(ans, n = count);
        }
        return ans;
    }

    private int binarySearch(int[] arr, int left, int max) {
        int right = arr.length;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > max) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
