package LeetCode.math;


//https://leetcode.com/problems/valid-perfect-square/submissions/
public class ValidPerfectSquare {
    public static void main(String[] args) {
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        System.out.println(validPerfectSquare.isPerfectSquare(16));
    }

    public boolean isPerfectSquare(int num) {
        int left = 0, right = 46340;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == num) return true;
            if (mid * mid < num) left = mid + 1;
            else if (mid * mid > num) right = mid - 1;
        }
        return false;
    }
}
