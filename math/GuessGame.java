package LeetCode.math;

//link - https://leetcode.com/problems/guess-number-higher-or-lower/
public class GuessGame {

    public static void main(String[] args) {

    }

    private int guess(int n) {
        return -1; //dummy method
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int mid = left + ((right - left) / 2);
        while (guess(mid) != 0) {
            mid = left + ((right - left) / 2);
            int result = guess(mid);
            if (result < 0) right = mid - 1;
            else left = mid + 1;
        }
        return mid;
    }
}
