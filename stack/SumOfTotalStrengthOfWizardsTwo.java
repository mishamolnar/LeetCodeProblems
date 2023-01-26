package LeetCode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfTotalStrengthOfWizardsTwo {
    public int totalStrength(int[] strength) {
            int mod = 1000000007;
            int[] leftSum = new int[strength.length + 1];
            long[] leftMul = new long[strength.length + 1];
            int[] leftBorder = new int[strength.length];
            int sum = 0;
            long mulSum = 0;
            for (int i = 0; i < strength.length; i++) {
                sum += strength[i];
                mulSum += ((long) strength[i] * (i + 1));
                leftSum[i + 1] = sum;
                leftMul[i + 1] = mulSum;
            }
            sum = 0;
            mulSum = 0;
            int[] rightSum = new int[strength.length + 1];
            long[] rightMul = new long[strength.length + 1];
            for (int i = strength.length - 1; i >= 0; i--) {
                sum += strength[i];
                mulSum += ((long) (strength.length - i) * strength[i]);
                rightSum[i] = sum;
                rightMul[i] = mulSum;
            }
            Deque<Integer> stack = new ArrayDeque<>();
            long res = 0;
            for (int i = 0; i <= strength.length; i++) {
                while (!stack.isEmpty() && (i == strength.length || strength[i] <= strength[stack.peekLast()])) {
                    int middle = stack.pollLast();
                    int left = stack.isEmpty() ? 0 : stack.peekLast() + 1;
                    int right = i;
                    int leftLength = middle - left + 1;
                    int rightLength = right - middle;
                    long leftCurrentSum = (leftMul[middle + 1] - leftMul[left] - ((long) left * (leftSum[middle + 1] - leftSum[left] % mod))) % mod;
                    long rightCurrentSum = (rightMul[middle + 1] - rightMul[right] - ((long) (strength.length - right) * (rightSum[middle + 1] - rightSum[right]) % mod)) % mod;
                    long allSum = (leftCurrentSum * rightLength % mod) + (rightCurrentSum * leftLength % mod);
                    res += (allSum * strength[middle]) % mod;
                }
                stack.addLast(i);
            }
            return (int) (res % mod);
    }

    public static void main(String[] args) {
        SumOfTotalStrengthOfWizardsTwo sum = new SumOfTotalStrengthOfWizardsTwo();
        System.out.println(sum.totalStrength(new int[]{3, 2, 1, 3}));
    }
}
