package LeetCode.math;

//
public class MySqrt {

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrtNewton(45987));
    }

    public int mySqrt(int x) {
        int left = 0, right = 46341;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (mid * mid > x) right = mid;
            else left = mid;
        }
        return left;
    }

    //Integer Newton

    public int mySqrtNewton(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
}
