package LeetCode.binarySearch;

import java.util.Arrays;

public class MinimumNumberOfDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length)
            return -1;
        int left = Arrays.stream(bloomDay).min().getAsInt();
        int right = Arrays.stream(bloomDay).max().getAsInt();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canForm(bloomDay, m, k, mid)) {
                right = mid;
            } else left = mid + 1;
        }
        return left;
    }

    private boolean canForm(int[] bloomDay, int m, int k, int day) {
        int currNum = 0, currFlow = 0;
        for (int bloom : bloomDay) {
            if (bloom <= day)
                currFlow++;
            else currFlow = 0;
            if (currFlow == k) {
                currNum++;
                currFlow = 0;
            }
        }
        return currNum >= m;
    }
}
