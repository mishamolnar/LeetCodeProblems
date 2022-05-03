package LeetCode.math;

//link - https://leetcode.com/problems/ugly-number-ii/
public class UglyNumbers {
    public int nthUglyNumber(int n) {
        int factor2 = 0, factor3 = 0, factor5 = 0;
        int[] numbers = new int[n + 1];
        numbers[0] = 1;
        for (int i = 1; i <= n; i++) {
            numbers[i] = Math.min(numbers[factor2] * 2, Math.min(numbers[factor3] * 3, numbers[factor5] * 5));
            if (numbers[i] == numbers[factor2] * 2) factor2++;
            if (numbers[i] == numbers[factor3] * 3) factor3++;
            if (numbers[i] == numbers[factor5] * 5) factor5++;
        }
        return numbers[n - 1];
    }


    public static void main(String[] args) {
        UglyNumbers ugly = new UglyNumbers();
        System.out.println(ugly.nthUglyNumber(20));
    }
}
