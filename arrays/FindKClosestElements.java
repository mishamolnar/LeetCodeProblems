package LeetCode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/find-k-closest-elements/
public class FindKClosestElements {
    public static void main(String[] args) {
        FindKClosestElements findKClosestElements = new FindKClosestElements();
        System.out.println(findKClosestElements.findClosestElements(new int[]{0,0,1,2,3,3,4,7,7,8}, 3, 5));
    }

    public List<Integer> findClosestElementsTwo(int[] A, int k, int x) {
        int left = 0, right = A.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - A[mid] > A[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        return Arrays.stream(A, left, left + k).boxed().collect(Collectors.toList());
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int start = getClosestIndex(arr, x);
        int left = start, right = start;
        while (right - left + 1 < k) {
            if (left > 0 && (right == arr.length - 1 || Math.abs(x - arr[left - 1]) <= Math.abs(arr[right + 1] - x))) {
                left--;
            } else right++;
        }
        for (int i = left; i <= right; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    private int getClosestIndex(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x < arr[mid]) right = mid - 1;
            else left = mid + 1;
        }
        if (left == arr.length) return arr.length - 1;
        if (right == -1) return 0;
        return arr[left] - x < x - arr[right] ? left : right;
    }
}
