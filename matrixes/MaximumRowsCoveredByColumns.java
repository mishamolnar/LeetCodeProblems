package LeetCode.matrixes;

import java.util.HashSet;

public class MaximumRowsCoveredByColumns {
    public int maximumRows(int[][] mat, int cols) {
        HashSet<Integer> set = new HashSet<>();
        return backtrack(mat, set, 0, cols);
    }

    private int backtrack(int[][] mat, HashSet<Integer> excluded, int start, int remains) {
        if (remains == 0)
            return countRows(mat, excluded);
        else {
            int res = 0;
            for (int i = start; i < mat[0].length; i++) {
                excluded.add(i);
                res = Math.max(res, backtrack(mat, new HashSet<>(excluded), i + 1, remains - 1));
                excluded.remove(i);
            }
            return res;
        }
    }


    private int countRows(int[][] mat, HashSet<Integer> excluded) {
        int res = 0;
        for (int[] ints : mat) {
            int sum = 0;
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == 1 && !excluded.contains(i))
                    sum++;
            }
            res += sum == 0 ? 1 : 0;
        }
        return res;
    }
}
