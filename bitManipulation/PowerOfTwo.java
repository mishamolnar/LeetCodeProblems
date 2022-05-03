package LeetCode.bitManipulation;

//link - https://leetcode.com/problems/power-of-two/submissions/
public class PowerOfTwo {


    // O(1) time and space
    public boolean isPowerOfTwo(int n) {
        int count = 0;

        if (n < 0) return false;

        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) count++;
        }

        return count == 1;
    }


    //more conventional
    public boolean isPowerOfTwoBuildIn(int n) {
        return n < 0 ? false : Integer.bitCount(n) == 1;
    }

    public static void main(String[] args) {
        System.out.println(2 >> 3);
    }
}
