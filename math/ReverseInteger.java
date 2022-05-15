package LeetCode.math;

//https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(-2147483648));
    }

    public int reverse(int x) {
        boolean negative = x < 0;
        int result = 0;
        while (x != 0) {
            int buff = x % 10;
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) return 0;
            result = result * 10 + buff;
            x /= 10;
        }
        return result;
    }
}
