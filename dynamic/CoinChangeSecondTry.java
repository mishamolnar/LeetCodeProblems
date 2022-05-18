package LeetCode.dynamic;

public class CoinChangeSecondTry {
    public static void main(String[] args) {
        CoinChangeSecondTry coinChangeSecondTry = new CoinChangeSecondTry();
        System.out.println(coinChangeSecondTry.coinChange(new int[]{2}, 3));
    }

    public int coinChange(int[] coins, int amount) {
        Integer[] amounts = new Integer[amount + 1];
        amounts[0] = 0;
        for (int coin : coins) {
            if (coin > amount) continue;
            amounts[coin] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0 || amounts[i - coins[j]] == null) continue;
                min = Math.min(min, amounts[i - coins[j]] + 1);
            }
            if (min != Integer.MAX_VALUE) amounts[i] = min;
        }
        return amounts[amount] != null ? amounts[amount] : -1;
    }
}
