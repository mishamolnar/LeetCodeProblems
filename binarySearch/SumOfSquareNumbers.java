package LeetCode.binarySearch;

import java.util.HashSet;

//https://leetcode.com/problems/sum-of-square-numbers/
public class SumOfSquareNumbers {

    public static void main(String[] args) {
//        System.out.println(Math.sqrt(Integer.MAX_VALUE));
//        System.out.println(Math.pow(Math.sqrt(Integer.MAX_VALUE), 2));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Math.pow(46340, 2));
        SumOfSquareNumbers sum = new SumOfSquareNumbers();
        System.out.println(sum.judgeSquareSum(1000));
    }

    public boolean judgeSquareSum(int c) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i <= Math.sqrt(c); i++) {
            set.add(i * i);
            if (set.contains(c - i * i)) {
                return true;
            }
        }
        return false;
    }
}
