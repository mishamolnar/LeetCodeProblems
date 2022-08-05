package LeetCode.stack;

import java.util.Stack;

public class SumOfTotalStrengthOfWizards {
    public int totalStrength(int[] strength) {
        long mod = 1000000007, res = 0;
        int n = strength.length;

        long[] leftSum = new long[n + 1], rightSum = new long[n + 1];
        long[] leftMul = new long[n + 1], rightMul = new long[n + 1];
        Stack<Integer> asc = new Stack<>();

        for (int i = 0; i < n; i++) {
            leftSum[i + 1] = (leftSum[i] + strength[i]) % mod;
            leftMul[i + 1] = (leftMul[i] + (long) (i + 1) * strength[i]) % mod;
        }

        for (int i = n - 1; i >= 0; i--) {
            rightSum[i] = (rightSum[i + 1] + strength[i]) % mod;
            rightMul[i] = (rightMul[i + 1] + (long) (n - i) * strength[i]) % mod;
        }

        for (int j = 0; j <= n; j++) {
            while (!asc.isEmpty() && (j == n || strength[asc.peek()] >= strength[j])) {
                int k = asc.pop();
                int i = asc.empty() ? 0 : asc.peek() + 1;
                long left = (mod + leftMul[k + 1] - leftMul[i] - (i * (leftSum[k + 1] - leftSum[i])) % mod) % mod;
                long right = (mod + rightMul[k + 1] - rightMul[j] - ((n - j) * (rightSum[k + 1] - rightSum[j])) % mod) % mod;
                long sum = (left * (j - k) + right * (k - i + 1)) % mod;
                res = (res + sum * strength[k]) % mod;
            }
            asc.push(j);
        }
        return (int) res;
    }
}
