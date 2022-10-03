package LeetCode.dynamic;

import java.util.Arrays;

public class NumberOfDiceRolls {

    //n * target * k
    public int numRollsToTarget(int n, int k, int target) {
        int mod = 1_000_000_007;
        long[] dp = new long[target + 1];
        Arrays.fill(dp, 1, Math.min(k + 1, target + 1), 1);
        n--;
        for (int i = 0; i < n; i++) {
            long[] dpBuff = new long[target + 1];
            for (int cell = 1; cell <= target; cell++) {
                long sum = 0;
                for (int currCell = cell - 1; currCell >= Math.max(cell - k, 1); currCell--) {
                    sum += dp[currCell];
                }
                dpBuff[cell] = (sum % mod);
            }
            dp = dpBuff;
        }
        return (int) (dp[target] % mod);
    }

    public int numRollsToTargetRef(int d, int f, int target) {
        int mod = 1_000_000_007;
        long[] dp = new long[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= d; i++) {
            for (int j = target; j >= 0; j--) {
                dp[j] = 0;
                for (int k = 1; k <= f; k++) {
                    if (j >= k) {
                        dp[j] = (dp[j] + dp[j - k]) % mod;
                    } else {
                        break;
                    }
                }
            }
        }
        return (int)dp[target];
    }

    public static void main(String[] args) {
        NumberOfDiceRolls numberOfDiceRolls = new NumberOfDiceRolls();
        System.out.println(numberOfDiceRolls.numRollsToTarget(5, 6, 18));
        System.out.println(numberOfDiceRolls.numRollsToTarget(30, 30, 500));
        System.out.println(numberOfDiceRolls.numRollsToTargetRef(5, 6, 18));
    }
}
