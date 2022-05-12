package LeetCode.math;

import java.util.HashSet;

//link - https://leetcode.com/problems/happy-number/
public class HappyNumber {


    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(4));
    }

    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (true) {
            if (n == 1) return true;
            else {
                n = processNum(n);
                if (hashSet.contains(n)) return false;
                hashSet.add(n);
            }
        }
    }

    private int processNum(int n) {
        int res = 0;
        while (n != 0) {
            res += Math.pow(n % 10, 2);
            n /= 10;
        }
        return res;
    }
}
