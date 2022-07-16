package LeetCode.math;

//https://leetcode.com/problems/powx-n/
public class PowXN {

    public double myPow(double x, int n) {
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        double buff = myPow(x, n / 2);
        if (n % 2 == 0) {
            return buff * buff;
        } else {
            return buff * buff * myPow(x, n / Math.abs(n));
        }
    }

    public static void main(String[] args) {
        PowXN powXN = new PowXN();
        System.out.println(powXN.myPow(0.00001, 2147483647));
    }

    public double myPowTwo(double x, int n) {
        if (n == 1) return x;
        if (n == 0) return 1;
        if (n == 2) return x * x;
        if (n > 0) {
            return n % 2 == 0 ? myPow(myPow(x, n / 2),  2) : x * myPow(myPow(x, n / 2),  2);
        } else {
            return 1 / x * myPow(1 / x, -(n + 1));
        }
    }
}
