package LeetCode.bitManipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// time, space - O(n)
// main method -
//    public int[] countOnes(int n) {
//        int[] result = new int[n + 1];
//        for (int i = 1; i < result.length; i++) {
//            result[i] = result[i / 2] + (i % 2);
//        }
//        return result;
//    }
// why does it work?
// 11 is 01011 and 22 is 10110 - same amount of ones for even (парні)
// 11 is 01011 and 23 is 10111 - amount of ones + 1, for twice bigger number. That is why we need  (i % 2)
// link - https://leetcode.com/problems/counting-bits/

public class CountingBits {
    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        System.out.println(Arrays.toString(countingBits.countBits(12)));
    }

    private static Map<Integer, Integer> hashMap = new HashMap<>();

    static  {
        hashMap.put(0, 0);
        hashMap.put(1, 1);
        hashMap.put(2, 1);
        hashMap.put(3, 2);
        hashMap.put(4, 1);
        hashMap.put(5, 2);
        hashMap.put(6, 2);
        hashMap.put(7, 3);
        hashMap.put(8, 1);
        hashMap.put(9, 2);
        hashMap.put(10, 2);
        hashMap.put(11, 3);
        hashMap.put(12, 2);
        hashMap.put(13, 3);
        hashMap.put(14, 3);
        hashMap.put(15, 4);
    }

    private static int getCount(int n) {
        return hashMap.get(n & 15) + hashMap.get((n & (15 << 4)) >> 4)
                + hashMap.get((n & (15 << 8)) >> 8)
                + hashMap.get((n & (15 << 12)) >> 12)
                + hashMap.get((n & (15 << 16)) >> 16)
                + hashMap.get((n & (15 << 20)) >> 20)
                + hashMap.get((n & (15 << 24)) >> 24)
                + hashMap.get((n & (15 << 28)) >> 28);
    }

    public int[] countBits(int n) {
        if (n == 0) return new int[] {0};
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = getCount(i);
        }
        return result;
    }

    public int[] countOnes(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i / 2] + (i % 2);
        }
        return result;
    }
}
