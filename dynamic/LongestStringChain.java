package LeetCode.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        //predecessor should have 1 leter less
        //and have all leters in the same order as next
        //brute force: with n^2 * len create graph of predecessor and the use DP to calculate longest sequence
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i < words.length; i++) {
            for (int j = i - 1; j >= 0 && words[j].length() + 1 >= words[i].length(); j--) {
                if (words[i].length() == words[j].length() + 1 && checkPredesessor(words[i], words[j])) {
                    graph.putIfAbsent(j, new ArrayList<>());
                    graph.get(j).add(i);
                }
            }
        }
        int[] dp = new int[words.length];
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (dp[entry.getKey()] == 0) {
                dp[entry.getKey()] = 1;
            }
            for (Integer next : entry.getValue()) {
                dp[next] = Math.max(dp[next], dp[entry.getKey()] + 1);
            }
        }
        return Math.max(Arrays.stream(dp).max().orElse(1), 1);
    }

    private boolean checkPredesessor(String str, String predecessor) { //str is always one character longer
        int p = 0;
        for (int s = 0; s < str.length(); s++) {
            if (p < predecessor.length() && str.charAt(s) == predecessor.charAt(p)) {
                p++;
            } else if (p != s) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LongestStringChain().longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
    }
}
