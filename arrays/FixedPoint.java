package LeetCode.arrays;

//https://leetcode.com/problems/fixed-point/solution/
public class FixedPoint {
    public int fixedPoint(int[] arr) {
        int left = 0, right = arr.length - 1, ans = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == mid) ans = Math.min(ans, mid);
            if (arr[mid] >= mid) right = mid - 1;
            else left = mid + 1;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
