package LeetCode.myImpls;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

public class Playground {
    public static void main(String[] args) {
        System.out.println(new Playground().countWays(new int[][]{{6, 10},{5, 15}}));
    }


    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> a[0] == b[0] ? -Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int max = -1, number = 0;
        for (int[] range : ranges) {
            if (max < range[0]) {
                number++;
            }
            max = Math.max(max, range[1]);
        }
        return BigInteger.TWO.pow(number).divideAndRemainder(BigInteger.valueOf(1_000_000_007))[1].intValue();
    }

    private long factorial(int num) {
        if (num < 0) return 0;
        long mod = 1_000_000_007, res = 1;
        while (num > 0) {
            res *= num;
            num--;
        }
        return res;
    }

    public long coloredCells(int n) {
        if (n == 1) return 1;
        if (n == 2) return 4;
        long counter = 5, adding = 3;
        for (int i = 2; i < n; i++) {
            counter += (adding * 2);
            counter += ((adding - 1) * 2);
            adding++;
        }
        return counter;
    }

    public int splitNum(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        int num1 = 0, num2 = 0;
        for (int i = 0; i < digits.length; i++) {
            if (i % 2 == 0) {
                num1 *= 10;
                num1 += (digits[i] - '0');
            } else {
                num2 *= 10;
                num2 += (digits[i] - '0');
            }
        }
        return num1 + num2;
    }
}
