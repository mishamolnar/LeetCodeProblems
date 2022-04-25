package LeetCode.dynamic;

// link - https://leetcode.com/problems/climbing-stairs/submissions/
// complexity  - O(n) time and space for caching solution
// complexity  - O(n) time and O(1) space for Fibonacci number
public class ClimbStairs {
    private static int[] stairs = new int[46];

    //recursion with caching
    public int climbStairs(int n) {
        if (n < 3) return n;
        if (stairs[n] != 0) return stairs[n];
        return stairs[n] = climbStairs(n - 1) + climbStairs(n - 2);
    }

    //fibonacci number with no extra space
    public int climbStairsFib(int n) {
        if (n < 3) return n;
        int a = 1;
        int b = 2;

        int count = 3;
        while (n != count) {
            int buff = b;
            b = a + b;
            a = buff;
            count++;
        }

        return a + b;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairsFib(6));
    }
}
