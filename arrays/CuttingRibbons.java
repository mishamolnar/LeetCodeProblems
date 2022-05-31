package LeetCode.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/cutting-ribbons/submissions/
public class CuttingRibbons {

    //O(n * log (n) * log (length)) -time complexity
    public int maxLength(int[] ribbons, int k) {
        Arrays.sort(ribbons);
        int left = 0, lastValid = 0, right = (int) Math.pow(10, 5);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean cut = isCutPossible(ribbons, mid, k);
            if (cut) {
                lastValid = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return lastValid;
    }

    private boolean isCutPossible(int[] ribbons, int length, int k) {
        int sum = 0;
        for (int ribbon : ribbons) {
            sum += ribbon / length;
        }
        return sum >= k;
    }
}
