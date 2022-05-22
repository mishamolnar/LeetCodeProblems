package LeetCode.binarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/check-if-n-and-its-double-exist/submissions/
public class CheckIfNAndItsDoubleExist {

    public static void main(String[] args) {
        CheckIfNAndItsDoubleExist checkIfNAndItsDoubleExist = new CheckIfNAndItsDoubleExist();
        System.out.println(checkIfNAndItsDoubleExist.checkIfExist(new int[]{-2,0,10,-19,4,6,-8}));
    }

    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (checkIfExists(arr, arr[i] * 2)) {
                if (arr[i] == 0 && arr[Math.max(i - 1, 0)] != 0 && Math.min(arr[i + 1], arr.length - 1) != 0) continue;
                return true;
            }
        }
        return false;
    }

    private boolean checkIfExists(int[] arr, int t) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == t) return true;
            else if (arr[mid] > t) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}
