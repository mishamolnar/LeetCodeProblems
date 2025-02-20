package LeetCode.dynamic;

//https://leetcode.com/problems/find-the-derangement-of-an-array/solution/
public class FindTheDerangementOfAnArray {

    public int findDerangement(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 0;
        for (int i = 2; i <= n; i++)
            dp[i] = (int)(((i - 1L) * (dp[i - 1] + dp[i - 2])) % 1000000007);
        return dp[n];
    }

    public int findDerangementConstant(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 0;
        int first = 1, second = 0;
        for (int i = 2; i <= n; i++) {
            int temp = second;
            second = (int)(((i - 1L) * (first + second)) % 1000000007);
            first = temp;
        }
        return second;
    }
}
