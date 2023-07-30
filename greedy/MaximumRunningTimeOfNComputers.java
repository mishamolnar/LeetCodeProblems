package LeetCode.greedy;

import java.util.Arrays;

public class MaximumRunningTimeOfNComputers {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long res = 0, extra = 0;
        int len = batteries.length, curr = batteries[len - n];
        for (int i = 0; i < len - n; i++) {
            extra += batteries[i];
        }
        for (int i = len - n + 1; i < len; i++) {
            if (extra < (long) (batteries[i] - curr) * (i - len + n)) {
                return curr + extra / (i - len + n);
            } else {
                curr = batteries[i];
                extra -= (long) (batteries[i] - curr) * (i - len + n);
            }
        }
        return curr + (extra / n);
    }


    public static void main(String[] args) {
        new MaximumRunningTimeOfNComputers().maxRunTime(3, new int[]{10,10,6,9,3});
    }
}
