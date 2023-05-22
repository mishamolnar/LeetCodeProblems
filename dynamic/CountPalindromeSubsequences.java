package LeetCode.dynamic;

import java.util.Arrays;

public class CountPalindromeSubsequences {
    private static final int MOD = 1_000_000_007;

    public int countPalindromes(String s) {
        int len = s.length();
        int[][][] left = new int[len][10][10];
        int[] counts = new int[10];
        for (int i = 0; i < len; i++) {
            int curr = s.charAt(i) - '0';
            if (i > 1) {
                for (int base = 0; base < 10; base++) {
                    for (int last = 0; last < 10; last++) {
                        left[i][base][last] = left[i - 1][base][last];
                        if (curr == last)
                            left[i][base][last] += counts[base];
                    }
                }
            }
            counts[curr]++;
        }
        int[][][] right = new int[len][10][10];
        Arrays.fill(counts, 0);
        for (int i = len - 1; i >= 0; i--) {
            int curr = s.charAt(i) - '0';
            if (i != len - 1) {
                for (int base = 0; base < 10; base++) {
                    for (int last = 0; last < 10; last++) {
                        right[i][base][last] = right[i + 1][base][last];
                        if (curr == last)
                            right[i][base][last] += counts[base];
                    }
                }
            }
            counts[curr]++;
        }
        long res = 0;
        for (int i = 2; i < len - 2; i++) {
            for (int base = 0; base < 10; base++) {
                for (int last = 0; last < 10; last++) {
                    res += (((long) left[i - 1][base][last] * right[i + 1][base][last]) % MOD);
                }
            }
        }
        return (int) res % MOD;
    }



    public static void main(String[] args) {
        System.out.println(new CountPalindromeSubsequences().countPalindromes("103301"));
    }
}
