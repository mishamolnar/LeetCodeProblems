package LeetCode.binarySearch;

import java.util.Arrays;

public class MinimumLimitOfBallsInBag {
    private int minimumLimitOfBalls(int[] nums, int operations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        while (right - left > 1) {
            int middle = left + (right - left) / 2;
            if (test(nums, middle, operations)) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return left;
    }


    private boolean test(int[] nums, int balls, int operations) {
        for (int curr : nums) {
            int operationsToDivideCurrent = curr / balls;
            operationsToDivideCurrent += curr % balls > 0 ? 1 : 0;
            operations -= operationsToDivideCurrent;
        }
        return operations >= 0;
    }
}
