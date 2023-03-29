package LeetCode.greedy;

import java.util.Arrays;

public class RedicingDIshes {
    public int maxSatisfaction(int[] satisfaction) {
        //-1, -1, -1, 5 -> 17
        //where to start?
        Arrays.sort(satisfaction);
        int res = 0;
        for (int i = 0; i < satisfaction.length; i++) {
            int curr = 0;
            for (int j = i; j < satisfaction.length; j++) {
                curr += satisfaction[j] * (j - i + 1);
            }
            res = Math.max(curr, res);
        }
        return res;
    }

    public int maxSatisfactionNlogN(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int ans = 0, curr = 0, sum = 0, len = satisfaction.length;
        for (int i = len - 1; i >= 0; i--) {
            sum += satisfaction[i];
            curr += sum;
            ans = Math.max(curr, ans);
        }
        return ans;
    }

}
