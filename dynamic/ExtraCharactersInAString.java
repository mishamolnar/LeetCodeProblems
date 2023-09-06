package LeetCode.dynamic;

import java.util.Arrays;

public class ExtraCharactersInAString {
    public int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i < dp.length; i++) dp[i] = i;
        for (int i = 0; i < s.length(); i++) {
            dp[i] = i == 0 ?  0 : Math.min(dp[i], dp[i - 1] + 1);
            for (String word : dictionary) {
                if (word.length() + i < dp.length && s.substring(i, i + word.length()).equals(word))
                    dp[i + word.length()] = Math.min(dp[i], dp[i + word.length()]);
            }
        }
        return Math.min(dp[s.length()], dp[s.length() - 1] + 1);
    }
}
