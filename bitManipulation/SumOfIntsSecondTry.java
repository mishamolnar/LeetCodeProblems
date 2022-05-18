package LeetCode.bitManipulation;

public class SumOfIntsSecondTry {

    public static void main(String[] args) {
        SumOfIntsSecondTry sumOfIntsSecondTry = new SumOfIntsSecondTry();
        System.out.println(sumOfIntsSecondTry.getSum(2, 2));
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
