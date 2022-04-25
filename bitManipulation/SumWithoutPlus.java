package LeetCode.bitManipulation;

public class SumWithoutPlus {
    public static void main(String[] args) {
        System.out.println(getSum(15, 5));
    }

    // link - https://leetcode.com/problems/sum-of-two-integers/
    // аналогія з додаванням в стовпчик
    // наприклад 15  + 5
    // 0 1 1 1 1
    //   0 1 0 1
    // 0 1 2 1 2
    // 0 0 1 0 1 - carry  (5), after <<  -> 10
    // 0 1 0 1 0 - 10, addition without carry
    // same operation with b == carry, a
    private static int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b; // те що потрібно буде перенести
            a = a ^ b; // те що спільне, звічайне додавання, без переносу
            b = carry << 1; // перенос вліво, бо залішок йде до більшого додавання
        }
        return a;
    }
}
