package LeetCode.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfitableSchemes {
    int mod = 1000000007;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int[][][] dp = new int[len + 1][minProfit + 1][n + 1];

        dp[0][0][n] = 1;

        for (int currGroup = 0; currGroup < len; currGroup++) {
            for (int prof = 0; prof <= minProfit; prof++) {
                for (int people = 0; people <= n; people++) {
                    dp[currGroup + 1][prof][people] += dp[currGroup][prof][people];
                    dp[currGroup + 1][prof][people] %= mod;
                    if (people < group[currGroup])
                        continue;

                    int nextProfit = Math.min(minProfit, prof + profit[currGroup]);
                    int nextPeopleLeft = people - group[currGroup];
                    dp[currGroup + 1][nextProfit][nextPeopleLeft] += dp[currGroup][prof][people];
                    dp[currGroup + 1][nextProfit][nextPeopleLeft] %= mod;
                }
            }
        }
        int res = 0;
        for (int people = 0; people <= n; people++) {
            res += dp[len][minProfit][people];
            res %= mod;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ProfitableSchemes().profitableSchemes(9, 5, new int[]{2,3,5}, new int[]{6,7,8}));
    }
}
