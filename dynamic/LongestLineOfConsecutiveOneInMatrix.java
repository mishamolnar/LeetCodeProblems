package LeetCode.dynamic;

//https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/solution/
public class LongestLineOfConsecutiveOneInMatrix {
    private static final int[][] DIRECTIONS = new int[][]{{0, -1}, {-1, -1}, {-1, 0},{-1, 1}};

    //O(mn) time and space
    //space can be O(n) cause we need only last line
    public int longestLine(int[][] mat) {
        int max = 0;
        int[][][] dp = new int[mat.length][mat[0].length][4];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                for (int k = 0; k < DIRECTIONS.length; k++) {
                    int prevI = i + DIRECTIONS[k][0];
                    int prevJ = j + DIRECTIONS[k][1];
                    int prev = prevI >= 0 && prevJ >= 0 && prevJ < mat[i].length ? dp[prevI][prevJ][k] : 0;
                    dp[i][j][k] = mat[i][j] == 0 ? 0 : 1 + prev;
                    max = Math.max(max, dp[i][j][k]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestLineOfConsecutiveOneInMatrix longest = new LongestLineOfConsecutiveOneInMatrix();
        System.out.println(longest.longestLine(new int[][]{{1,1,1,1},{0,1,1,0},{0,0,0,1}}));
    }
}
