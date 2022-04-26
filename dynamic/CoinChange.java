package LeetCode.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

// link - https://leetcode.com/problems/coin-change/submissions/
// time complexity - O(amount * coins.length) , space - O(amount)

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        Arrays.sort(coins);
        if (amount < coins[0]) return -1;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1); // value to return if not possible to form this

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) { //iterating through amounts up to needed amount with setting an optimal value to each amount
            for (Integer coin : coins) { //check each coin for best solution. If amount 20 and coins [2, 3, 5],
                // then we need to get min of amount[15] + 1, amount[17] + 1, amount[18] + 1
                if (i == coin) {
                    dp[i] = 1; // if there is single coin with that value - set to 1
                    break;
                }
                int prev = i - coin;
                if (prev > 0 && dp[prev] > 0) {
                    dp[i] = dp[i] == -1 ? dp[i] = dp[prev] + 1 : Math.min(dp[i], dp[prev] + 1); //set to dp if current value -1, otherwise get minimum
                }
            }
        }
        return dp[amount];
    }

    public ArrayList<Integer> coinChangeWithPass(int[] coins, int amount) {
        if (amount == 0) return new ArrayList<>();

        Arrays.sort(coins);
        if (coins[0] > amount) return null;

        int[] dp = new int[amount + 1];
        int[] path = new int[amount + 1];
        Arrays.fill(dp, -1);

        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i == coin) {
                    dp[i] = 1;
                    path[i] = coin;
                    break;
                }
                if (i - coin > 0 && dp[i - coin] >= 0 && dp[i - coin] + 1 < dp[i]) {
                    dp[i] = dp[i - coin] + 1;
                    path[i] = coin;
                } else if (i - coin > 0 && dp[i - coin] >= 0) {
                    dp[i] = dp[i - coin] + 1;
                    path[i] = coin;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (amount != 0) {
            result.add(path[amount]);
            amount -= path[amount];
        }
        return result;
    }


    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        ArrayList<Integer> result = coinChange.coinChangeWithPass(new int[]{2, 3, 5, 10}, 47);
        System.out.println(result.toString());
    }
}
