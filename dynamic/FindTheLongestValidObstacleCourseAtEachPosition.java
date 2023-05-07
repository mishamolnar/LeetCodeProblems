package LeetCode.dynamic;

import java.util.Arrays;

public class FindTheLongestValidObstacleCourseAtEachPosition {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int len = obstacles.length;
        int[] dp = new int[len], ans = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < obstacles.length; i++) {
            int res = binarySearch(dp, obstacles[i]);
            dp[res] = obstacles[i];
            ans[i] = res + 1;
        }
        return ans;
    }

    private int binarySearch(int[] dp, int num) {
        int left = 0, right = dp.length;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (predicate(dp, mid, num)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean predicate(int[] dp, int i, int num) {
        return num > dp[i] || (num < dp[i] && (i == 0 || dp[i - 1] <= num));
    }


    public static void main(String[] args) {
        FindTheLongestValidObstacleCourseAtEachPosition find = new FindTheLongestValidObstacleCourseAtEachPosition();
        System.out.println(Arrays.toString(find.longestObstacleCourseAtEachPosition(new int[]{3, 1, 5, 6, 4, 2})));
    }
}
