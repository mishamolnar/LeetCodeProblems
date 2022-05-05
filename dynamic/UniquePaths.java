package LeetCode.dynamic;

//link - https://leetcode.com/problems/unique-paths/submissions/
public class UniquePaths {
    //naive recursion
    //time - O(2^(n + m))
    //space - O(1)
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) return 1;
        int left = 0;
        if (n > 0) left = uniquePaths(m, n - 1);
        int up = 0;
        if (m > 0) up = uniquePaths(m - 1, n);
        return up + left;
    }

    //top down memoization
    // O(nm) time and space
    public int uniquePathsMemo(int m, int n) {
        int[][] memo = new int[m][n];
        return  helper(m, n, memo);
    }

    private int helper(int m, int n, int[][] memo) {
        if (m == 1 && n == 1) return memo[0][0] = 1;
        if ((m > 0 && n > 0) && memo[m - 1][n - 1] != 0) return memo[m - 1][n - 1];
        int left = 0;
        if (n > 1 && m > 0) {
            left = helper(m, n - 1, memo);
            memo[m - 1][n - 2] = left;
        }
        int up = 0;
        if (m > 1 && n > 0) {
            up = helper(m - 1, n, memo);
            memo[m - 2][n - 1] = up;
        }
        return up + left;
    }

    //O(mn) time and space
    public int uniquePathsIterable(int m, int n) {
        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) memo[i][j] = 1;
                if (j == 0) memo[i][j] = 1;
                if (i != 0 && j != 0) {
                    int up = memo[i - 1][j];
                    int down = memo[i][j - 1];
                    memo[i][j] = up + down;
                }
            }
        }
        return memo[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
            System.out.println(uniquePaths.uniquePathsIterable(23, 12));
    }
}
