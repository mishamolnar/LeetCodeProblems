package LeetCode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class EqualSumArraysWithMinimumNumberOfOperations {
    public int minOperations(int[] nums1, int[] nums2) {
        if (Math.min(nums1.length, nums2.length) * 6 < Math.max(nums1.length, nums2.length))
            return -1;
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        if (sum1 < sum2) {
            return minOperations(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int res = 0, one = nums1.length - 1, two = 0;
        while (sum1 > sum2) {
            if (one >= 0 && nums1[one] - 1 >= 6 - nums2[two]) {
                sum1 -= (nums1[one] - 1);
                nums1[one--] = 1;
            } else {
                sum2 += (6 - nums2[two]);
                nums2[two++] = 6;
            }
            res++;
        }
        return res;
    }
}
