package LeetCode.arrays;


import java.util.Collections;

//link - https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(new int[]{0}, 0, new int[]{1}, 1);
    }

    //О(n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m -1, tail2 = n - 1, pointer = n + m - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[pointer--] = nums1[tail1] > nums2[tail2] ? nums1[tail1--] : nums2[tail2--];
        }
        while (tail2 >= 0) { // переносимо все з першого масиву якщо потрібно
            nums1[pointer--] = nums2[tail2--];
        }
    }
}
