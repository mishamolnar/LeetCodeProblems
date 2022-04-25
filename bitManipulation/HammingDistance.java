package LeetCode.bitManipulation;

// link - https://leetcode.com/problems/number-of-1-bits/submissions/
// >>> - побітовий здвиг вправо, який добавляє тільки нулі справа, без залежності від знаку
public class HammingDistance {
    public int hammingDistance(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) count++; // рахуємо скільки одиничок
            n = n >>> 1;
        }
        return count;
    }
}
