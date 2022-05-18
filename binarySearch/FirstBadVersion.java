package LeetCode.binarySearch;

//https://leetcode.com/problems/first-bad-version/
public class FirstBadVersion {

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        System.out.println(firstBadVersion.firstBadVersion(3));
    }


    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    private boolean isBadVersion(int n) {
        boolean[] arr = new boolean[]{false, true, true};
        return arr[n - 1];
    }
}
