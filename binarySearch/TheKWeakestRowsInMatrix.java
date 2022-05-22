package LeetCode.binarySearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/submissions/
public class TheKWeakestRowsInMatrix {
    public static void main(String[] args) {
        TheKWeakestRowsInMatrix theKWeakestRowsInMatrix = new TheKWeakestRowsInMatrix();
        System.out.println(theKWeakestRowsInMatrix.countSoldiers(new int[]{1,1,1,1,1,1}));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        int[] ans = new int[k];

        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[]{countSoldiers(mat[i]), i});
            if (pq.size() > k) pq.poll();
        }

        while (k > 0) {
            ans[--k] = pq.poll()[1];
        }

        return ans;
    }

    private int countSoldiers(int[] mat) {
        int left = 0, right = mat.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mat[mid] == 0) right = mid - 1;
            else left = mid  + 1;
        }
        return left;
    }
}
