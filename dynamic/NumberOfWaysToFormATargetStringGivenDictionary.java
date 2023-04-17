package LeetCode.dynamic;

public class NumberOfWaysToFormATargetStringGivenDictionary {
    private static final int MOD = 1_000_000_007;

    public int numWays(String[] words, String target) {
        int len = target.length();
        long[] dp = new long[len];
        for (int i = 0; i < words[0].length(); i++) {
            int[] dict = countCharacters(words, i);
            for (int j = dp.length - 1; j >= 0; j--) {
                dp[j] += (long) dict[target.charAt(j) - 'a'] * (j == 0 ? 1 : dp[j - 1]);
                dp[j] %= MOD;
            }
        }
        return (int) dp[len - 1];
    }
    
    private int[] countCharacters(String[] words, int index) {
        int[] res = new int[26];
        for (String word : words) {
            res[word.charAt(index) - 'a']++;
        }
        return res;
    }
}
