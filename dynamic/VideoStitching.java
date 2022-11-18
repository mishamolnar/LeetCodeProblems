package LeetCode.dynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class VideoStitching {
    public int videoStitching(int[][] clips, int time) {

        //1. sort array
        //2. 0 -> 0
        //3. dp[start] ... dp[end] fill with min dp[x], dp[start] + 1
        //4. return dp[len]
        int[] dp = new int[time];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.sort(clips, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        dp[0] = 0;
        for (int[] clip : clips) {
            if (dp[clip[0]] == Integer.MAX_VALUE)
                return -1;
            for (int i = clip[0]; i < clip[1]; i++) {
                dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
            }
        }
        return dp[time - 1] == Integer.MAX_VALUE ? -1 : dp[time - 1];
    }
}
