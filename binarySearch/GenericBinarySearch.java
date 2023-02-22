package LeetCode.binarySearch;

import java.util.function.Predicate;

public class GenericBinarySearch {

    public static void main(String[] args) {
        System.out.println(new GenericBinarySearch().rightMost(new int[]{1, 1, 2, 3, 4, 4, 4, 4, 5, 6, 7, 8}, ((a) -> a > 1)));
    }

    private int leftMost(int[] arr, Predicate<Integer> pre) {
        int left = -1; //excluded
        int right = arr.length; //answer
        while (right - left > 1) {
            int middle = left + (right - left) / 2;
            if (pre.test(arr[middle])) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }


    private int rightMost(int[] arr, Predicate<Integer> pre) {
        int left = -1; //answer
        int right = arr.length; //excluded
        while (right - left > 1) {
            int middle = left + (right - left) / 2;
            if (pre.test(arr[middle])) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return left;
    }


}
