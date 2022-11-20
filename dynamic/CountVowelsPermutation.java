package LeetCode.dynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CountVowelsPermutation {
    //a, e, o, u, i
    //0, 1, 2, 3, 4,
    private static final int[][] RULES = new int[][]{{1}, {0, 4}, {3, 4}, {0}, {0, 1, 2, 3}};
    public int countVowelPermutation(int n) {
        long[] curr = new long[5];
        Arrays.fill(curr, 1);
        for (int i = 1; i < n; i++) {
            long[] next = new long[5];
            for (int j = 0; j < curr.length; j++) {
                for (int permutation : RULES[j]) {
                    next[permutation] += curr[j];
                    next[permutation] %= 1_000_000_007;
                }
            }
            curr = next;
        }
        return (int) (Arrays.stream(curr).sum() % 1_000_000_007);
    }
}
