package LeetCode.dynamic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// link - https://leetcode.com/problems/word-break/submissions/
public class WordBreak {




    public boolean wordBreakTwo(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            if (!dp[i]) continue;
            for (String s1 : wordDict) {
                if (s1.length() + i > s.length()) continue;
                if (s.substring(i, i + s1.length()).equals(s1)) dp[i + s1.length()] = true;
            }
        }
        return dp[s.length()];
    }



    // n3 approach (time)/ space = n2 + wordDict
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, 0, new HashSet<>(wordDict), new Boolean[s.length()]);
    }

    // top-down
    public boolean wordBreak(final String s, int i, Set<String> wordSet, Boolean[] memo) {
        if (i == s.length()) return true; // ми в кінці слова
        if (memo[i] != null) return memo[i]; // якщо ми вже знаємо чи можливо дійти до цього символу
        for (int j = i + 1; j < s.length(); ++j) { // шукаємо потрібні нам слова від початку і запускаємо цей самий алгоритм на залишок
            // тобто на першій ітерації при String s = "leetcode" ми шукаємо слова l, le, lee, leet - знайшли і запускаємо той самий алгоритм для code
            if (wordSet.contains(s.substring(i, j)) && wordBreak(s, j, wordSet, memo)) return memo[i] = true;
        }

        return memo[i] = false; // якщо ні одна з операцій не спрацювала - то в масив добавляємо фолс
    }


    //time - n3/ space = n2 + wordDict
    public boolean wordBreakBottomUp(String s, List<String> wordDict) {
        final int len = s.length();
        HashSet<String> hashSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= len; ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && hashSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }


    // my approach
    // complexity O(n2m) m - dictionary length; space - O(1)
    public boolean wordBreakDictionary(String s, List<String> wordDict) {
        final int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 0; i <= len ; i++) {
            if (!dp[i]) continue;
            for (String word : wordDict) {
                int target = word.length() + i;
                if (target > len || dp[target]) continue;
                if (s.substring(i, target).equals(word)) {
                    dp[target] = true;
                }
            }
        }

        return dp[len];
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        //System.out.println(wordBreak.wordBreakTwo("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
        System.out.println(wordBreak.wordBreakTwo("leetcode", List.of("leet", "code", "sand", "and", "cat")));
    }


}
