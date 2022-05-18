package LeetCode.binarySearch;

//https://leetcode.com/problems/arranging-coins/
public class ArrangingCoins {

    public static void main(String[] args) {
        ArrangingCoins arrangingCoins = new ArrangingCoins();
        System.out.println(arrangingCoins.arrangeCoins(Integer.MAX_VALUE));
    }

    public int arrangeCoins(int n) {
        int left = 0, right = (int) Math.pow(2, 18);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midS = (int) (Math.pow(mid, 2) * 0.5 + mid * 0.5);
            if (midS > n) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }
}
