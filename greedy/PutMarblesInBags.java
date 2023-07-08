package LeetCode.greedy;

import java.util.Arrays;

public class PutMarblesInBags {
    public long putMarbles(int[] weights, int k) {
        int[] pairs = new int[weights.length - 1];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(pairs);
        long ans = 0;
        System.out.println(Arrays.toString(pairs));
        for (int start = 0, end = pairs.length - 1; start < k && start < pairs.length; start++, end--) {
            ans += pairs[end];
            ans -= pairs[start];
        }
        return ans;
    }
}
