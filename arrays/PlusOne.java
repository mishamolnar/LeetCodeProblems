package LeetCode.arrays;

import java.util.Arrays;

//link - https://leetcode.com/problems/plus-one/submissions/
public class PlusOne {
    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{9})));
    }

    //як і в стовпчик
    //space - O(1) time O(n)
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int pointer = digits.length - 1;
        while (carry != 0 && pointer >= 0) {
            if (digits[pointer] < 9) {
                digits[pointer] = digits[pointer] + 1;
                carry--;
            } else {
                digits[pointer] = 0;
                pointer--;
            }
        }
        if (pointer <= 0 && digits[0] == 0) {
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;
            return arr;
        }
        return digits;
    }
}
