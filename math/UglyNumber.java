package LeetCode.math;


//link - https://leetcode.com/problems/ugly-number/
public class UglyNumber {

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.isUgly(14));
    }

    public boolean isUgly(int n) {
        for (int i = 2; i < 6 && n > 0; i++) {
            while (n % i == 0)
                n /= i;
        }
        return n == 1;
    }
}
