package LeetCode.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
public class FindTheDistanceValueBetweenTwoArrays {
    public static void main(String[] args) {
        FindTheDistanceValueBetweenTwoArrays findTheDistanceValueBetweenTwoArrays = new FindTheDistanceValueBetweenTwoArrays();
        System.out.println(findTheDistanceValueBetweenTwoArrays.findTheDistanceValue(new int[]{1,4,2,3}, new int[]{-4,-3,6,10,20,30}, 3));
    }

    //n log n time complexity
    //constant space
    //n2 complexity for
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int distance = arr1.length;
        for (int j : arr1) {
            if (binarySearch(arr2, j) <= d) distance--;
        }
        return distance;
    }

    private int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int minDifference = Integer.MAX_VALUE;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            minDifference = Math.min(Math.abs(arr[mid] - target), minDifference);
            if (arr[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return minDifference;
    }
}
