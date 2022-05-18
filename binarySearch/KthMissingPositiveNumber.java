package LeetCode.binarySearch;

// https://leetcode.com/problems/kth-missing-positive-number/submissions/
public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        KthMissingPositiveNumber kthMissingPositiveNumber = new KthMissingPositiveNumber();
        System.out.println(kthMissingPositiveNumber.findKthPositive(new int[]{2}, 1));
    }

    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            int midMissing = arr[mid] - (mid + 1);
            if (midMissing >= k) right = mid - 1;
            else  left = mid + 1;
        }
        if (right < 0) return arr[0] - (arr[0] - k);
        return arr[right] + (k - (arr[right] - (right + 1)));
    }
}
